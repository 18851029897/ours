package com.ours.service.user;

import com.ours.model.user.UserGroup;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
public interface IUserGroupService {

    public List<UserGroup> findUserGroupList(UserGroup params);

    public int saveUserGroup(UserGroup params);

    public int updateUserGroup(UserGroup params);

}
