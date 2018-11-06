package com.ours.service.redis;

/**
 * Created by fish on 2018/10/31.
 */
public interface IRedisService {

    /**
     * 保存到缓存
     *
     * @param key
     * @param timeOut 超时时间 秒
     * @param value
     */
    void set(String key, Integer timeOut, String value);

    /**
     * 保存到缓存
     *
     * @param key
     * @param value
     */
    void set(String key, String value);

    /**
     * 通过key获取
     *
     * @param key
     * @return
     */
    String get(String key);

    /**
     * 通过key移除
     *
     * @param key
     */
    void remove(String key);

}
