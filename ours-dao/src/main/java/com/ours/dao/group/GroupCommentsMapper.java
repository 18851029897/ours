package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupComments;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Mapper
public interface GroupCommentsMapper {

    @InsertProvider(type = SqlProvider.class, method = "saveGroupComments")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer saveGroupComments(GroupComments params);

    @SelectProvider(type = SqlProvider.class, method = "findGroupCommentsList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "topicId", column = "TOPIC_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "content", column = "CONTENT"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "activityId", column = "ACTIVITY_ID"),
    })
    List<GroupComments> findGroupCommentsList(GroupComments params);

}
