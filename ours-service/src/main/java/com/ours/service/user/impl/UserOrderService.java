package com.ours.service.user.impl;

import com.ours.dao.user.UserOrderMapper;
import com.ours.model.user.UserOrder;
import com.ours.service.user.IUserOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fish on 2018/11/27.
 */
@Service
public class UserOrderService implements IUserOrderService {

    @Autowired
    private UserOrderMapper userOrderMapper;

    @Override
    public Integer saveUserOrder(UserOrder params) {
        return this.userOrderMapper.saveUserOrder(params);
    }

    @Override
    public Integer updateUserOrder(UserOrder params) {
        return this.userOrderMapper.updateUserOrder(params);
    }

    @Override
    public UserOrder findUserOrder(UserOrder params) {
        return this.userOrderMapper.findUserOrder(params);
    }
}
