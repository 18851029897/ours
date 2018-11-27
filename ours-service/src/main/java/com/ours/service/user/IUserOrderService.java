package com.ours.service.user;

import com.ours.model.user.UserOrder;

/**
 * Created by fish on 2018/11/27.
 */
public interface IUserOrderService {

    Integer saveUserOrder(UserOrder params);

    Integer updateUserOrder(UserOrder params);

    UserOrder findUserOrder(UserOrder params);

}
