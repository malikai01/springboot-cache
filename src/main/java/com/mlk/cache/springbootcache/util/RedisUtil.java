package com.mlk.cache.springbootcache.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * redis工具类
 *
 * @author malikai
 * @date 2021-5-20 13:46
 */
@SuppressWarnings("unchecked")
@Component
public class RedisUtil {
    @SuppressWarnings("rawtypes")
    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 批量删除对应的value
     *
     * @param keys
     * @author malikai
     * @date 2021-5-20 13:51
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     * @author malikai
     * @date 2021-5-20 13:51
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 删除对应的value
     *
     * @param key
     * @author malikai
     * @date 2021-5-20 13:51
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return boolean
     * @author malikai
     * @date 2021-5-20 13:51
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return java.lang.Object
     * @author malikai
     * @date 2021-5-20 13:51
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate
                .opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 写入缓存,不设置过期时间
     *
     * @param key
     * @param value
     * @return boolean
     * @author malikai
     * @date 2021-5-20 13:50
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存，设置过期时间
     *
     * @param key
     * @param value
     * @param expireTime
     * @param unit
     * @return boolean
     * @author malikai
     * @date 2021-5-20 13:50
     */
    public boolean set(final String key, Object value, Long expireTime, TimeUnit unit) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate
                    .opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, unit);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
