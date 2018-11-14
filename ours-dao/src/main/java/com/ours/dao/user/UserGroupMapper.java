package com.ours.dao.user;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.user.UserGroup;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
@Mapper
public interface UserGroupMapper {

    @SelectProvider(type = SqlProvider.class, method = "findUserGroupList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "sort", column = "SORT"),
            @Result(property = "modifyTime", column = "MODIFY_TIME"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    List<UserGroup> findUserGroupList(UserGroup params);


    @InsertProvider(type = SqlProvider.class, method = "saveUserGroup")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveUserGroup(UserGroup params);


    @UpdateProvider(type = SqlProvider.class, method = "updateUserGroup")
    int updateUserGroup(UserGroup params);
}
