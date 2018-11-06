package com.ours.dao.user;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.user.UserInfo;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

/**
 * Created by fish on 2018/11/6.
 */
@Mapper
public interface UserInfoMapper {

    @InsertProvider(type = SqlProvider.class, method = "saveUserInfo")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int saveUserInfo(UserInfo params);

}
