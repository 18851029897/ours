package com.ours.service.base.impl;

import com.alibaba.fastjson.JSONObject;
import com.ours.common.constant.RedisConstant;
import com.ours.common.util.EmptyUtil;
import com.ours.dao.base.BaseSysParamMapper;
import com.ours.dao.sql.SqlProvider;
import com.ours.model.base.BaseSysParam;
import com.ours.service.base.IBaseSysParamService;
import com.ours.service.redis.IRedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by fish on 2018/11/6.
 */
@Service
public class BaseSysParamService implements IBaseSysParamService {

    private static Logger baseLog = LoggerFactory.getLogger(BaseSysParamService.class);

    @Autowired
    private BaseSysParamMapper baseSysParamMapper;

    @Autowired
    private IRedisService redisService;

    @Override
    public String findValueByKey(BaseSysParam params) {
        String key = RedisConstant.BASE_SYS_PARAM + "-" + params.getParamKey().toUpperCase();
        baseLog.info("redis key is =" + key);
        String value = this.redisService.get(key);
        if (EmptyUtil.isEmpty(value)) {
            value = this.baseSysParamMapper.findValueByKey(params).getParamValue();
            this.redisService.set(key, RedisConstant.TIME_OUT, value);
        }
        baseLog.info("redis value is =" + value);
        return value;
    }
}
