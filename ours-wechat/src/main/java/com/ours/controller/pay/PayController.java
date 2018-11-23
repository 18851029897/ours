package com.ours.controller.pay;

import com.ours.common.back.DataResponse;
import com.ours.common.util.MD5Util;
import com.ours.model.base.BaseSysParam;
import com.ours.service.base.IBaseSysParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse pay(Integer flag, Integer id) {
        String appid = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_APP_ID"));
        String mch_id = this.baseSysParamService.findValueByKey(new BaseSysParam("WX_MCH_ID"));
        String nonce_str = UUID.randomUUID().toString().replaceAll("-", "");
        String sign = MD5Util.MD5Encode("");
        String body = "";
        String out_trade_no = "";
        String total_fee = "";
        String spbill_create_ip = "";
        String notify_url = "";
        String trade_type = "JSAPI";
        String openid = "openid";
        return null;
    }


    @RequestMapping(value = "/notify", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse wxNotify() {
        return null;
    }


}
