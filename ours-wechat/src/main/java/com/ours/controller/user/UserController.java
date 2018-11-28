package com.ours.controller.user;

import com.ours.common.back.DataResponse;
import com.ours.common.util.EmptyUtil;
import com.ours.controller.pay.PayController;
import com.ours.model.user.UserOrder;
import com.ours.service.user.IUserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fish on 2018/11/27.
 */
@Controller
@RequestMapping("user")
public class UserController {

    private static Logger baseLog = LoggerFactory.getLogger(PayController.class);

    @Autowired
    private IUserOrderService userOrderService;

    @RequestMapping(value = "/isPay", method = RequestMethod.GET)
    @ResponseBody
    public DataResponse pay(UserOrder params) {
        params = this.userOrderService.findUserOrder(params);
        if (EmptyUtil.isEmpty(params)) {
            return new DataResponse(1000, "success", 0);//未购买
        } else {
            return new DataResponse(1000, "success", 1);
        }
    }

}
