package com.ours.dao.user;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.user.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by fish on 2018/11/6.
 */
@Mapper
public interface UserInfoMapper {

    @InsertProvider(type = SqlProvider.class, method = "saveUserInfo")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    int saveUserInfo(UserInfo params);

    @SelectProvider(type = SqlProvider.class, method = "findUserInfo")
    @Results({
        @Result(property = "userId", column = "USER_ID"),
        @Result(property = "openId", column = "OPEN_ID"),
        @Result(property = "sex", column = "SEX"),
        @Result(property = "nickName", column = "NICK_NAME"),
        @Result(property = "province", column = "PROVINCE"),
        @Result(property = "city", column = "CITY"),
        @Result(property = "country", column = "COUNTRY"),
        @Result(property = "headImgUrl", column = "HEAD_IMG_URL"),
        @Result(property = "phone", column = "PHONE"),
        @Result(property = "unionId", column = "UNION_ID"),
        @Result(property = "subscribe", column = "SUBSCRIBE"),
        @Result(property = "payAmount", column = "PAY_AMOUNT"),
        @Result(property = "inviteUserId", column = "INVITE_USER_ID"),
        @Result(property = "modifyTime", column = "MODIFY_TIME"),
        @Result(property = "createTime", column = "CREATE_TIME"),
    })
    UserInfo findUserInfo(UserInfo params);

    List<UserInfo> findUserInfoList(UserInfo params);

}
