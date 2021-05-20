package com.mlk.cache.springbootcache.controller.front;

import com.mlk.cache.springbootcache.model.Users;
import com.mlk.cache.springbootcache.service.IUserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author malikai
 * @date 2021年05月20日 14:18
 */
@Controller
@RequestMapping("mlk/userTest")
public class UserFrontController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ApiOperation(value = "获取用户信息")
    public String queryById(@RequestParam Integer userId, HttpServletRequest request) {
        Users stu = userService.queryUserById(userId);
        request.setAttribute("users", stu);
        System.out.println("--------------" + stu.getUsername());
        return "student";
    }
}
