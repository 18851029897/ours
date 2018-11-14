package com.ours.controller.login;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.common.util.HttpsUtil;
import com.ours.common.util.MappingUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.model.user.UserInfo;
import com.ours.service.base.IBaseSysParamService;
import com.ours.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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

        System.out.println(MappingUtil.getResultsStr(UserInfo.class));

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
        this.userInfoService.saveUserInfo(params);
        return new DataResponse(1000, "success");
    }


    @RequestMapping("test")
    @ResponseBody
    public DataResponse test() {
        BaseSysParam params = new BaseSysParam();
        params.setParamKey("image.small.width");
        this.baseSysParamService.findValueByKey(params);
        return new DataResponse(1000, "success");
    }

}
