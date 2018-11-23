package com.ours.controller.pay;

import com.ours.common.back.DataResponse;
import com.ours.model.base.BaseSysParam;
import com.ours.service.base.IBaseSysParamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public DataResponse pay() {
        //WX_APP_ID
        String appId = this.baseSysParamService.findValueByKey(new BaseSysParam());


        return null;
    }


}
