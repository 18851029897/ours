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
}
