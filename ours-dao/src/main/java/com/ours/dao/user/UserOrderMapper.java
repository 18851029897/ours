package com.ours.dao.user;

import com.ours.dao.sql.SqlProvider;
import com.ours.model.user.UserOrder;
import org.apache.ibatis.annotations.*;

/**
 * Created by fish on 2018/11/27.
 */
@Mapper
public interface UserOrderMapper {

    @InsertProvider(type = SqlProvider.class, method = "saveUserOrder")
    @Options(useGeneratedKeys = true, keyProperty = "orderNo")
    Integer saveUserOrder(UserOrder params);

    @UpdateProvider(type = SqlProvider.class, method = "updateUserOrder")
    Integer updateUserOrder(UserOrder params);

    @SelectProvider(type = SqlProvider.class, method = "findUserOrder")
    @Results({
            @Result(property = "orderNo", column = "ORDER_NO"),
            @Result(property = "tradeNo", column = "TRADE_NO"),
            @Result(property = "userId", column = "USER_ID"),
            @Result(property = "orderType", column = "ORDER_TYPE"),
            @Result(property = "groupId", column = "GROUP_ID"),
            @Result(property = "topicId", column = "TOPIC_ID"),
            @Result(property = "activityId", column = "ACTIVITY_ID"),
            @Result(property = "body", column = "BODY"),
            @Result(property = "payType", column = "PAY_TYPE"),
            @Result(property = "payAmount", column = "PAY_AMOUNT"),
            @Result(property = "status", column = "STATUS"),
            @Result(property = "remark", column = "REMARK"),
            @Result(property = "successTime", column = "SUCCESS_TIME"),
            @Result(property = "modifyTime", column = "MODIFY_TIME"),
            @Result(property = "createTime", column = "CREATE_TIME"),
    })
    UserOrder findUserOrder(UserOrder params);
}
