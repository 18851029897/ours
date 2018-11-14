package com.ours.service.user;


import com.ours.model.user.UserInfo;

/**
 * Created by fish on 2018/11/6.
 */
public interface IUserInfoService {

    public int saveUserInfo(UserInfo params);

    public UserInfo findUserInfo(UserInfo params);

}
