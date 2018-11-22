package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupTopic;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Mapper
public interface GroupTopicMapper {

//    @SelectProvider(type = SqlProvider.class, method = "findGroupTopicList")
//    @Results({
//            @Result(property = "id", column = "ID"),
//            @Result(property = "groupId", column = "GROUP_ID"),
//            @Result(property = "userId", column = "USER_ID"),
//            @Result(property = "tagId", column = "TAG_ID"),
//            @Result(property = "topicTitle", column = "TOPIC_TITLE"),
//            @Result(property = "topicContent", column = "TOPIC_CONTENT"),
//            @Result(property = "topicType", column = "TOPIC_TYPE"),
//            @Result(property = "topicPrice", column = "TOPIC_PRICE"),
//            @Result(property = "topicShow", column = "TOPIC_SHOW"),
//            @Result(property = "topicRead", column = "TOPIC_READ"),
//            @Result(property = "isTop", column = "IS_TOP"),
//            @Result(property = "isDel", column = "IS_DEL"),
//            @Result(property = "isGood", column = "IS_GOOD"),
//            @Result(property = "modifyTime", column = "MODIFY_TIME"),
//            @Result(property = "createTime", column = "CREATE_TIME"),
//    })
//    List<GroupTopic> findGroupTopicList(GroupTopic params);


    @InsertProvider(type = SqlProvider.class, method = "saveGroupTopic")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveGroupTopic(GroupTopic params);

}
