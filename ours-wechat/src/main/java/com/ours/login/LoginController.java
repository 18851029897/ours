package com.ours.login;

import com.ours.common.back.DataResponse;
import com.ours.common.util.HttpsUtil;
import com.ours.common.util.MappingUtil;
import com.ours.model.base.BaseSysParam;
import com.ours.service.base.IBaseSysParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fish on 2018/11/6.
 */
@RestController
public class LoginController {

    @Autowired
    private IBaseSysParamService baseSysParamService;

    public static void main(String args[]) {

        System.out.println(MappingUtil.getResultsStr(BaseSysParam.class));

    }

    @RequestMapping("login")
    @ResponseBody
    public DataResponse login(String code) {
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

}
