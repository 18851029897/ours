package com.ours.service.pay.impl;

import com.ours.common.back.DataResponse;
import com.ours.model.user.UserInfo;
import com.ours.model.user.UserOrder;
import com.ours.service.pay.IPayService;
import com.ours.service.user.IUserInfoService;
import com.ours.service.user.IUserOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by fish on 2018/11/27.
 */
@Transactional
@Service
public class PayService implements IPayService {

    private static Logger baseLog = LoggerFactory.getLogger(PayService.class);

    @Autowired
    private IUserOrderService userOrderService;

    @Autowired
    private IUserInfoService userInfoService;

    @Override
    public DataResponse wxNotify(UserOrder params) {
        baseLog.info("微信回调业务逻辑处理开始ing...");
        //1.更新用户订单
        this.userOrderService.updateUserOrder(params);

        //2.更新用户表payAmount
        params = this.userOrderService.findUserOrder(params);
        UserInfo userInfo = this.userInfoService.findUserInfo(new UserInfo(params.getUserId()));
        BigDecimal fee = userInfo.getPayAmount().add(params.getPayAmount());
        userInfo.setPayAmount(fee);
        userInfo.setModifyTime(new Date());
        this.userInfoService.updateUserInfo(userInfo);
        baseLog.info("微信回调业务逻辑处理结束ing...");
        return new DataResponse(1000, "success");
    }

}
