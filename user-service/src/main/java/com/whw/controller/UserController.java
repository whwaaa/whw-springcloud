package com.whw.controller;

import com.whw.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.whw.pojo.User;

import javax.annotation.Resource;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @GetMapping(value = "/{id}")
    public User queryById(@PathVariable(value = "id") Long id) {
        return userService.queryById(id);
    }
}
