package com.mlk.cache.springbootcache.controller;

import com.mlk.cache.springbootcache.model.Users;
import com.mlk.cache.springbootcache.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author malikai
 * @version 1.0
 * @date 2021-5-8 11:36
 */
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("getUserById")
    public Users queryUserById(@RequestParam Integer userId) {
        return userService.queryUserById(userId);
    }
}
