package com.ours.controller.base;

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
 * Created by fish on 2018/11/13.
 */
@Controller
@RequestMapping("base")
public class BaseController {

    private static Logger baseLog = LoggerFactory.getLogger(BaseController.class);

    @Autowired
    private IBaseSysParamService baseSysParamService;

    /**
     * 查询用户所在的圈子
     *
     * @return
     */
    @RequestMapping(value = "/findPubTag", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse findGroupInfoByUser() {
        BaseSysParam params = new BaseSysParam();
        params.setParamKey("MEMBER_PUBLIC_TAG");
        String json = this.baseSysParamService.findValueByKey(params);
        return new DataResponse(1000, "success", json);
    }

}
