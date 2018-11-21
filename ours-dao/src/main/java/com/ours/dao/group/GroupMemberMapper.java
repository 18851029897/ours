package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupMember;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
@Mapper
public interface GroupMemberMapper {

    @SelectProvider(type = SqlProvider.class, method = "findGroupMemberList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "memberIdentity", column = "MEMBER_IDENTITY"),
            @Result(property = "memberStatus", column = "MEMBER_STATUS"),
    })
    List<GroupMember> findGroupMemberList(GroupMember params);


    @SelectProvider(type = SqlProvider.class, method = "findGroupMemberList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "memberIdentity", column = "MEMBER_IDENTITY"),
            @Result(property = "memberStatus", column = "MEMBER_STATUS"),
    })
    GroupMember findGroupMember(GroupMember params);


    @InsertProvider(type = SqlProvider.class, method = "saveGroupMember")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveGroupMember(GroupMember params);


    @UpdateProvider(type = SqlProvider.class, method = "updateGroupMember")
    int updateGroupMember(GroupMember params);

}
