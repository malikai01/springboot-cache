package com.mlk.cache.springbootcache.dao;

import com.mlk.cache.springbootcache.model.Users;
import com.mlk.cache.springbootcache.model.UsersDto;
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
    UsersDto queryUserById(Integer userId);

    /**
     * 新增用户
     *
     * @param user
     * @return void
     * @author malikai
     * @date 2021-5-8 15:05
     * @version 1.0.0
     **/
    int add(Users user);

    /**
     * 更新用户
     *
     * @param user
     * @return void
     * @author malikai
     * @date 2021-5-8 15:09
     * @version 1.0.0
     **/
    int update(Users user);

    /**
     * 删除用户
     *
     * @param userId
     * @return void
     * @author malikai
     * @date 2021-5-8 15:12
     * @version 1.0.0
     **/
    int delete(Integer userId);
}