package com.mlk.cache.springbootcache.service.impl;

import com.mlk.cache.springbootcache.dao.UsersMapper;
import com.mlk.cache.springbootcache.event.UserChangeEvent;
import com.mlk.cache.springbootcache.event.convert.UserEventConvert;
import com.mlk.cache.springbootcache.model.Users;
import com.mlk.cache.springbootcache.service.IUserService;
import com.mlk.cache.springbootcache.event.util.ApplicationEventUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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

    @Override
    @Cacheable(value = "queryUserById", key = "#userId")
    public Users queryUserById(Integer userId) {
        Users users = new Users();
        BeanUtils.copyProperties(usersMapper.queryUserById(userId), users);
        return users;
    }

    @Override
    public void add(Users user) {
        usersMapper.add(user);
        //发布用户变更事件
        applicationEventUtil.sendChangeEventSingle(new UserChangeEvent<>(user));
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
