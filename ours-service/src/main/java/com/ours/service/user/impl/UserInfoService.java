package com.ours.service.user.impl;

import com.ours.dao.user.UserInfoMapper;
import com.ours.model.user.UserInfo;
import com.ours.service.user.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fish on 2018/11/6.
 */
@Service
public class UserInfoService implements IUserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public int saveUserInfo(UserInfo params) {
        return this.userInfoMapper.saveUserInfo(params);
    }
}