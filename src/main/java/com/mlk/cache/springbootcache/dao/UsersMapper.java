package com.mlk.cache.springbootcache.dao;

import com.mlk.cache.springbootcache.model.Users;
import org.springframework.stereotype.Repository;

/**
 * @author malikai
 * @version 1.0.0
 * @date 2021-4-25 17:01
 **/
@Repository
public interface UsersMapper {

    /**
     * 获取用户信息
     *
     * @param userId
     * @return org.apache.catalina.User
     * @author malikai
     * @date 2021-4-25 17:02
     **/
    Users queryUserById(Integer userId);
}