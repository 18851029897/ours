package com.ours.controller.login;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.common.util.HttpsUtil;
import com.ours.common.util.MappingUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.model.group.*;
import com.ours.model.user.UserInfo;
import com.ours.model.user.UserOrder;
import com.ours.service.base.IBaseSysParamService;
import com.ours.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by fish on 2018/11/6.
 */
@RestController
public class LoginController {

    @Autowired
    private IBaseSysParamService baseSysParamService;

    @Autowired
    private IUserInfoService userInfoService;

    public static void main(String args[]) {

        System.out.println(MappingUtil.getResultsStr(UserOrder.class));

    }

    /**
     * 微信小程序登录
     *
     * @param code
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse login(String code) {
        if (EmptyUtil.isEmpty(code)) {
            return new DataResponse(1001, "参数缺失. code");
        }
        BaseSysParam param = new BaseSysParam();
        param.setParamKey("WX_APP_ID");
        String appId = this.baseSysParamService.findValueByKey(param);
        param.setParamKey("WX_APP_SECRET");
        String secret = this.baseSysParamService.findValueByKey(param);
        param.setParamKey("WX_CODE2SESSION_URL");
        String url = this.baseSysParamService.findValueByKey(param) + "?appid=" + appId + "&secret=" + secret + "&js_code=" + code + "&grant_type=authorization_code";
        String response = HttpsUtil.get(url);
        return new DataResponse(1000, "success", response);
    }

    /**
     * 保存小程序用户信息
     *
     * @return
     */
    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public DataResponse saveUserInfo(UserInfo params) {
        //根据openid排重
        UserInfo isExist = this.userInfoService.findUserInfo(new UserInfo(params.getOpenId()));
        //不存在就新增一条, 存在就更新
        if (EmptyUtil.isEmpty(isExist)) {
            params.setModifyTime(new Date());
            params.setCreateTime(new Date());
            this.userInfoService.saveUserInfo(params);
        } else {
            params.setModifyTime(new Date());
            this.userInfoService.updateUserInfo(params);
        }
        return new DataResponse(1000, "success", params);
    }


    @RequestMapping("test")
    @ResponseBody
    public DataResponse test() {
        return new DataResponse(1000, "success");
    }

}
