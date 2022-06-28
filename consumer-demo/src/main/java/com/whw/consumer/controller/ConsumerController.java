package com.whw.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.whw.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/consumer")
//@DefaultProperties(defaultFallback = "defaultFallback")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoverydClient;

    @GetMapping("/{id}")
    @HystrixCommand(defaultFallback = "defaultFallback")
//    @HystrixCommand
    public String queryById(@PathVariable Long id) {

        if (id == 1)
            throw new RuntimeException("网络拥堵!");

        String url = "http://localhost:9091/user/" + id;
//        ServiceInstance server = discoveryClient.getInstances("user-service").get(0);
//        url = "http://" + server.getHost() + ":" + server.getPort() + "/user/" + id;

        // 负载均衡: 不在通过host和端口访问, 而是直接通过服务名称调用
        url = "http://user-service/user/" + id;

        return restTemplate.getForObject(url, String.class);
    }

    public String defaultFallback() {
        return "对不起, 网络拥堵!";
    }
}
