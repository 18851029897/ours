package com.ours.service.redis.impl;

import com.ours.service.redis.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by fish on 2018/10/31.
 */
@Service
public class RedisService implements IRedisService {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public void set(String key, Integer timeOut, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.setex(key, timeOut, value);
    }

    @Override
    public void set(String key, String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set(key, value);
    }

    @Override
    public String get(String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }

    @Override
    public void remove(String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.del(key);
    }
}
