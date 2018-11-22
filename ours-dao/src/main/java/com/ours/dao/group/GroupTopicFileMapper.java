package com.ours.dao.group;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.group.GroupTopicFile;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/22.
 */
@Mapper
public interface GroupTopicFileMapper {

    @SelectProvider(type = SqlProvider.class, method = "findGroupTopicFileList")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "fileName", column = "FILE_NAME"),
            @Result(property = "fileType", column = "FILE_TYPE"),
            @Result(property = "topicId", column = "TOPIC_ID"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    List<GroupTopicFile> findGroupTopicFileList(GroupTopicFile params);


    @InsertProvider(type = SqlProvider.class, method = "saveGroupTopicFile")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int saveGroupTopicFile(GroupTopicFile params);

}
