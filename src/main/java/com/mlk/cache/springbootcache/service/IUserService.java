package com.mlk.cache.springbootcache.service;


import com.mlk.cache.springbootcache.model.Users;

public interface IUserService {
    Users queryUserById(Integer userId);

    void add(Users user);

    void update(Users user);

    void delete(Integer userId);
}
