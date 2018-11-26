package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupActivityJoin;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/25.
 */
@Mapper
public interface GroupActivityJoinMapper {

    @SelectProvider(type = SqlProvider.class, method = "findGroupActivityJoinList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "activityId", column = "ACTIVITY_ID"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    List<GroupActivityJoin> findGroupActivityJoinList(GroupActivityJoin params);


    @InsertProvider(type = SqlProvider.class, method = "saveGroupActivityJoin")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveGroupActivityJoin(GroupActivityJoin params);

}
