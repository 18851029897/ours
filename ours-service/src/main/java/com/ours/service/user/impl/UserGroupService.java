package com.ours.service.user.impl;

import com.ours.dao.user.UserGroupMapper;
import com.ours.model.user.UserGroup;
import com.ours.service.user.IUserGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
@Service
public class UserGroupService implements IUserGroupService {

    @Autowired
    private UserGroupMapper userGroupMapper;

    @Override
    public List<UserGroup> findUserGroupList(UserGroup params) {
        return this.userGroupMapper.findUserGroupList(params);
    }

    @Override
    public int saveUserGroup(UserGroup params) {
        return this.userGroupMapper.saveUserGroup(params);
    }

    @Override
    public int updateUserGroup(UserGroup params) {
        return this.userGroupMapper.updateUserGroup(params);
    }
}
