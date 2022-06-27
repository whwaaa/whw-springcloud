package com.whw.user.controller;

import com.whw.user.pojo.User;
import com.whw.user.service.UserService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/{id}")
    public User queryById(@PathVariable Long id) {
        return userService.queryById(id);
    }
}
