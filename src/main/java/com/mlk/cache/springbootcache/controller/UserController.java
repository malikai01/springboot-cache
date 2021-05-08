package com.mlk.cache.springbootcache.controller;

import com.mlk.cache.springbootcache.model.Users;
import com.mlk.cache.springbootcache.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author malikai
 * @version 1.0
 * @date 2021-5-8 11:36
 */
@RestController
@Api("用户api Controller")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("getUserById")
    @ApiOperation(value = "获取用户信息", notes = "根据用户id获取用户信息")
    public Users queryUserById(@RequestParam Integer userId) {
        return userService.queryUserById(userId);
    }

    @PostMapping("add")
    @ApiOperation(value = "添加用户信息", notes = "添加用户信息")
    public void add(@RequestBody Users user) {
        userService.add(user);
    }

    @PostMapping("update")
    @ApiOperation(value = "更新用户信息", notes = "更新用户信息")
    public void update(@RequestBody Users user) {
        userService.update(user);
    }

    @GetMapping("delete")
    @ApiOperation(value = "删除用户信息", notes = "根据用户id删除用户信息")
    public void delete(@RequestParam Integer userId) {
        userService.delete(userId);
    }
}
