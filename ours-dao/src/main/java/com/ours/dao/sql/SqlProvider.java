package com.ours.dao.sql;

import com.ours.common.util.EmptyUtil;
import com.ours.model.base.BaseSysParam;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by fish on 2018/10/29.
 */
public class SqlProvider {

    public String findValueByKey(BaseSysParam params) {
        String sql = new SQL() {{
            SELECT("*");
            FROM("base_sys_param");
            if (EmptyUtil.isNotEmpty(params.getParamKey())) {
                WHERE("PARAM_KEY='" + params.getParamKey() + "'");
            }
        }}.toString();
        System.out.println(sql);
        return sql;
    }

}
