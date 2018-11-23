package com.ours.service.user;

import com.ours.model.user.UserGroup;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
public interface IUserGroupService {

    List<UserGroup> findUserGroupList(UserGroup params);

    Integer saveUserGroup(UserGroup params);

    Integer updateUserGroup(UserGroup params);

}
