package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupTag;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/13.
 */
@Mapper
public interface GroupTagMapper {

    @SelectProvider(type = SqlProvider.class, method = "findGroupTagList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "tagName", column = "TAG_NAME"),
            @Result(property = "sort", column = "SORT"),
            @Result(property = "isDel", column = "IS_DEL"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "tagType", column = "TAG_TYPE"),
    })
    List<GroupTag> findGroupTagList(GroupTag params);


    @SelectProvider(type = SqlProvider.class, method = "findGroupTagList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "tagName", column = "TAG_NAME"),
            @Result(property = "sort", column = "SORT"),
            @Result(property = "isDel", column = "IS_DEL"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "tagType", column = "TAG_TYPE"),
    })
    GroupTag findGroupTag(GroupTag params);


    @InsertProvider(type = SqlProvider.class, method = "saveGroupTag")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveGroupTag(GroupTag params);

}
