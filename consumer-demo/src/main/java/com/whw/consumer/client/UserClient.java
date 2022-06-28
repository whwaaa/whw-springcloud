package com.whw.consumer.client;

import com.whw.consumer.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service")
public interface UserClient {

    //String url = "http://user-service/user/" + id;
    @GetMapping("/user/{id}")
    public String queryById(@PathVariable Long id);
}


