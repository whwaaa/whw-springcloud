package com.whw.consumer.controller;

import com.whw.consumer.client.UserClient;
import com.whw.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cf")
public class ConsumerFeignController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public String queryById(@PathVariable Long id) {
        return userClient.queryById(id);
    }

}
