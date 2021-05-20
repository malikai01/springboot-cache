package com.mlk.cache.springbootcache.service.impl;

import com.mlk.cache.springbootcache.dao.UsersMapper;
import com.mlk.cache.springbootcache.event.UserChangeEvent;
import com.mlk.cache.springbootcache.event.convert.UserEventConvert;
import com.mlk.cache.springbootcache.model.Users;
import com.mlk.cache.springbootcache.service.IUserService;
import com.mlk.cache.springbootcache.event.util.ApplicationEventUtil;
import com.mlk.cache.springbootcache.util.JsonUtil;
import com.mlk.cache.springbootcache.util.RedisUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author malikai
 * @version 1.0
 * @date 2021-4-25 16:45
 */
@Service
@Component
public class UserService implements IUserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private ApplicationEventUtil applicationEventUtil;
    @Autowired
    private UserEventConvert eventConvert;
    @Autowired
    private RedisUtil redisUtil;

    @Override
    @Cacheable(value = "queryUserById", key = "#userId")
    public Users queryUserById(Integer userId) {
        String key = String.format("queryUserById:userId:%d", userId);
        System.out.println(JsonUtil.object2JSON(redisUtil.get(key)));
        Users users = (Users) redisUtil.get(key);
        if (users == null) {
            users = new Users();
            BeanUtils.copyProperties(usersMapper.queryUserById(userId), users);
            redisUtil.set(key, users, 5L, TimeUnit.MINUTES);
        }
        return users;
    }

    @Override
    public void add(Users user) {
        int result = usersMapper.add(user);
        if (result > 0) {
            //发布用户变更事件
            applicationEventUtil.sendChangeEventSingle(new UserChangeEvent<>(user));
        }
    }

    @Override
    public void update(Users user) {
        usersMapper.update(user);
    }

    @Override
    public void delete(Integer userId) {
        usersMapper.delete(userId);
    }
}
