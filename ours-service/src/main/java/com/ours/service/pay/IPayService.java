package com.ours.service.pay;

import com.ours.common.back.DataResponse;
import com.ours.model.user.UserOrder;

/**
 * Created by fish on 2018/11/27.
 */
public interface IPayService {

    DataResponse wxNotify(UserOrder params);

}
