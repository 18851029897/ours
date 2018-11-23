package com.ours.service.user;


import com.ours.model.user.UserInfo;

/**
 * Created by fish on 2018/11/6.
 */
public interface IUserInfoService {

    Integer saveUserInfo(UserInfo params);

    Integer updateUserInfo(UserInfo params);

    UserInfo findUserInfo(UserInfo params);

}
