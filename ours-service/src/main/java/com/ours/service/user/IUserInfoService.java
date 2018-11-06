package com.ours.service.user;

import com.rabbitmq.http.client.domain.UserInfo;

/**
 * Created by fish on 2018/11/6.
 */
public interface IUserInfoService {

    int saveUserInfo(UserInfo params);

}
