package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/12.
 */
@Mapper
public interface GroupInfoMapper {

    @InsertProvider(type = SqlProvider.class, method = "saveGroupInfo")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    Integer saveGroupInfo(GroupInfo params);

    @UpdateProvider(type = SqlProvider.class, method = "updateGroupInfo")
    Integer updateGroupInfo(GroupInfo params);


    @SelectProvider(type = SqlProvider.class, method = "findGroupInfoList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "groupPhotoUrl", column = "GROUP_PHOTO_URL"),
            @Result(property = "groupName", column = "GROUP_NAME"),
            @Result(property = "groupTitle", column = "GROUP_TITLE"),
            @Result(property = "groupDesc", column = "GROUP_DESC"),
            @Result(property = "groupType", column = "GROUP_TYPE"),
            @Result(property = "groupPrice", column = "GROUP_PRICE"),
            @Result(property = "isDel", column = "IS_DEL"),
            @Result(property = "validityDay", column = "VALIDITY_DAY"),
            @Result(property = "freeDay", column = "FREE_DAY"),
            @Result(property = "modifyTime", column = "MODIFY_TIME"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    List<GroupInfo> findGroupInfoList(GroupInfo params);


    @SelectProvider(type = SqlProvider.class, method = "findGroupInfoList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "groupPhotoUrl", column = "GROUP_PHOTO_URL"),
            @Result(property = "groupName", column = "GROUP_NAME"),
            @Result(property = "groupTitle", column = "GROUP_TITLE"),
            @Result(property = "groupDesc", column = "GROUP_DESC"),
            @Result(property = "groupType", column = "GROUP_TYPE"),
            @Result(property = "groupPrice", column = "GROUP_PRICE"),
            @Result(property = "isDel", column = "IS_DEL"),
            @Result(property = "validityDay", column = "VALIDITY_DAY"),
            @Result(property = "freeDay", column = "FREE_DAY"),
            @Result(property = "modifyTime", column = "MODIFY_TIME"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    GroupInfo findGroupInfo(GroupInfo params);
}
