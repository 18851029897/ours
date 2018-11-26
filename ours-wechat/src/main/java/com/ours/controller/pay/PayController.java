package com.ours.controller.pay;

import com.ours.common.back.DataResponse;
import com.ours.common.util.MD5Util;
import com.ours.common.util.OrderNoUtil;
import com.ours.common.util.PayUtil;
import com.ours.common.vo.pay.PaymentVO;
import com.ours.model.base.BaseSysParam;
import com.ours.model.user.UserInfo;
import com.ours.service.base.IBaseSysParamService;
import com.ours.service.user.IUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by fish on 2018/11/23.
 */
@Controller
@RequestMapping("wxPay")
public class PayController {

    private static Logger baseLog = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private IBaseSysParamService baseSysParamService;

    @Autowired
    private IUserInfoService userInfoService;

    /**
     * 统一下单接口
     *
     * @param params
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse pay(PaymentVO params) throws Exception {
        String appid = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_APP_ID"));
        String mchId = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_PAY_MCH_ID"));
        String tradeType = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_PAY_TRADE_TYPE"));
        String key = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_PAY_KEY"));
        String payUrl = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_PAY_NOTIFY_URL"));

        //商品名称
        String body = "测试商品名称";
        String total_fee = String.valueOf(new BigDecimal(params.getTotal_fee()).multiply(new BigDecimal(100)).intValue());
        //组装参数，用户生成统一下单接口的签名
        Map<String, String> packageParams = new HashMap<String, String>();
        packageParams.put("appid", appid);
        packageParams.put("mch_id", mchId);
        packageParams.put("nonce_str", params.getNonce_str());
        packageParams.put("body", params.getBody());
        packageParams.put("out_trade_no", params.getOut_trade_no());//商户订单号
        packageParams.put("total_fee", total_fee);//支付金额，这边需要转成字符串类型，否则后面的签名会失败
        packageParams.put("notify_url", params.getNotify_url());//支付成功后的回调地址
        packageParams.put("trade_type", tradeType);//支付方式
        packageParams.put("openid", params.getOpenid());

        String prestr = PayUtil.createLinkString(packageParams); // 把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串

        //MD5运算生成签名，这里是第一次签名，用于调用统一下单接口
        String mysign = PayUtil.sign(prestr, key, "utf-8").toUpperCase();

        //拼接统一下单接口使用的xml数据，要将上一步生成的签名一起拼接进去
        String xml = "<xml>" + "<appid>" + appid + "</appid>"
                + "<body><![CDATA[" + params.getBody() + "]]></body>"
                + "<mch_id>" + mchId + "</mch_id>"
                + "<nonce_str>" + params.getNonce_str() + "</nonce_str>"
                + "<notify_url>" + params.getNotify_url() + "</notify_url>"
                + "<openid>" + params.getOpenid() + "</openid>"
                + "<out_trade_no>" + params.getOut_trade_no() + "</out_trade_no>"
                + "<spbill_create_ip>" + params.getSpbill_create_ip() + "</spbill_create_ip>"
                + "<total_fee>" + total_fee + "</total_fee>"
                + "<trade_type>" + tradeType + "</trade_type>"
                + "<sign>" + mysign + "</sign>"
                + "</xml>";

        baseLog.info("调试模式_统一下单接口 请求XML数据：" + xml);

        //调用统一下单接口，并接受返回的结果
        String res = PayUtil.httpRequest(payUrl, "POST", xml);

        baseLog.info("调试模式_统一下单接口 返回XML数据：" + res);

        // 将解析结果存储在HashMap中
        Map map = PayUtil.doXMLParse(res);

        String return_code = (String) map.get("return_code");//返回状态码

        Map<String, String> result = new HashMap<String, String>();//返回给小程序端需要的参数
        String prepay_id = null;
        if (return_code == "SUCCESS" || return_code.equals(return_code)) {
            prepay_id = (String) map.get("prepay_id");//返回的预付单信息
            result.put("nonceStr", params.getNonce_str());
            result.put("package", "prepay_id=" + prepay_id);
            Long timeStamp = System.currentTimeMillis() / 1000;
            result.put("timeStamp", timeStamp + "");//这边要将返回的时间戳转化成字符串，不然小程序端调用wx.requestPayment方法会报签名错误
            //拼接签名需要的参数
            String stringSignTemp = "appId=" + appid + "&nonceStr=" + params.getNonce_str() + "&package=prepay_id=" + prepay_id + "&signType=MD5&timeStamp=" + timeStamp;
            //再次签名，这个签名用于小程序端调用wx.requesetPayment方法
            String paySign = PayUtil.sign(stringSignTemp, key, "utf-8").toUpperCase();
            result.put("paySign", paySign);
        }
        result.put("appid", appid);
        return new DataResponse(1000, "success", result);
    }


    /**
     * 支付回调接口
     *
     * @param request
     * @param response
     */
    @RequestMapping(value = "/notify")
    public void wxNotify(HttpServletRequest request, HttpServletResponse response) {
        StringBuffer buffer = new StringBuffer();
        String key = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_PAY_KEY"));
        String orderId = null;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            br.close();
            //sb为微信返回的xml
            String notityXml = sb.toString();
            baseLog.info("接收到的报文：" + notityXml);
            Map map = PayUtil.doXMLParse(notityXml);
            String returnCode = (String) map.get("return_code");
            if ("SUCCESS".equals(returnCode)) {
                //验证签名是否正确
                Map<String, String> validParams = PayUtil.paraFilter(map);  //回调验签时需要去除sign和空值参数
                String validStr = PayUtil.createLinkString(validParams);//把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
                String sign = PayUtil.sign(validStr, key, "utf-8").toUpperCase();//拼装生成服务器端验证的签名
                //根据微信官网的介绍，此处不仅对回调的参数进行验签，还需要对返回的金额与系统订单的金额进行比对等
                if (sign.equals(map.get("sign"))) {
                    /**此处添加自己的业务逻辑代码start**/
                    //TODO

                    /**此处添加自己的业务逻辑代码end**/
                    //通知微信服务器已经支付成功
                    buffer.append("<xml>");
                    buffer.append("<return_code>SUCCESS</return_code>");
                    buffer.append("<return_msg>OK</return_msg>");
                    buffer.append("</xml>");
                }
            } else {
                buffer.append("<xml>");
                buffer.append("<return_code>FAIL</return_code>");
                buffer.append("<return_msg>ERROR</return_msg>");
                buffer.append("</xml>");
            }
            baseLog.info(buffer.toString());
            baseLog.info("微信支付回调数据结束");
            BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());
            out.write(buffer.toString().getBytes());
            out.flush();
            out.close();
        } catch (Exception e) {
            baseLog.error(e.getMessage());
        }
    }


}
