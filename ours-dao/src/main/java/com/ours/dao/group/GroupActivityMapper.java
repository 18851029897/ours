package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupActivity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Mapper
public interface GroupActivityMapper {

    @SelectProvider(type = SqlProvider.class, method = "findGroupActivityList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "tagId", column = "TAG_ID"),
            @Result(property = "activityTitle", column = "ACTIVITY_TITLE"),
            @Result(property = "activityContent", column = "ACTIVITY_CONTENT"),
            @Result(property = "activityType", column = "ACTIVITY_TYPE"),
            @Result(property = "activityPrice", column = "ACTIVITY_PRICE"),
            @Result(property = "activityRead", column = "ACTIVITY_READ"),
            @Result(property = "activityCount", column = "ACTIVITY_COUNT"),
            @Result(property = "isDel", column = "IS_DEL"),
            @Result(property = "isEnd", column = "IS_END"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "modifyTime", column = "MODIFY_TIME"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    List<GroupActivity> findGroupActivityList(GroupActivity params);


    @SelectProvider(type = SqlProvider.class, method = "findGroupActivityList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "tagId", column = "TAG_ID"),
            @Result(property = "activityTitle", column = "ACTIVITY_TITLE"),
            @Result(property = "activityContent", column = "ACTIVITY_CONTENT"),
            @Result(property = "activityType", column = "ACTIVITY_TYPE"),
            @Result(property = "activityPrice", column = "ACTIVITY_PRICE"),
            @Result(property = "activityRead", column = "ACTIVITY_READ"),
            @Result(property = "activityCount", column = "ACTIVITY_COUNT"),
            @Result(property = "isDel", column = "IS_DEL"),
            @Result(property = "isEnd", column = "IS_END"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "modifyTime", column = "MODIFY_TIME"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    GroupActivity findGroupActivity(GroupActivity params);

    @InsertProvider(type = SqlProvider.class, method = "saveGroupActivity")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveGroupActivity(GroupActivity params);

    @UpdateProvider(type = SqlProvider.class, method = "updateGroupActivity")
    Integer updateGroupActivity(GroupActivity params);

}
