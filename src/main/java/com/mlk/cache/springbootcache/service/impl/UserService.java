package com.mlk.cache.springbootcache.service.impl;

import com.mlk.cache.springbootcache.dao.UsersMapper;
import com.mlk.cache.springbootcache.model.Users;
import com.mlk.cache.springbootcache.service.IUserService;
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

    @Override
    @Cacheable(value = "queryUserById", key = "#userId")
    public Users queryUserById(Integer userId) {
        return usersMapper.queryUserById(userId);
    }
}
