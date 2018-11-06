package com.ours.dao.base;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.base.BaseSysParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;

/**
 * Created by fish on 2018/11/6.
 */
@Mapper
public interface BaseSysParamMapper {

    @SelectProvider(type = SqlProvider.class, method = "findValueByKey")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "paramKey", column = "PARAM_KEY"),
            @Result(property = "paramValue", column = "PARAM_VALUE"),
            @Result(property = "type", column = "TYPE"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "remark", column = "REMARK"),
            @Result(property = "updateTime", column = "UPDATE_TIME"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    BaseSysParam findValueByKey(BaseSysParam params);

}
