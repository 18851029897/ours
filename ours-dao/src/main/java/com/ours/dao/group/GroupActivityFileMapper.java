package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupActivityFile;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/25.
 */
@Mapper
public interface GroupActivityFileMapper {

    @SelectProvider(type = SqlProvider.class, method = "findGroupActivityFileList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "activityId", column = "ACTIVITY_ID"),
            @Result(property = "fileName", column = "FILE_NAME"),
            @Result(property = "fileType", column = "FILE_TYPE"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    List<GroupActivityFile> findGroupActivityFileList(GroupActivityFile params);


    @InsertProvider(type = SqlProvider.class, method = "saveGroupActivityFile")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer saveGroupActivityFile(GroupActivityFile params);

}
