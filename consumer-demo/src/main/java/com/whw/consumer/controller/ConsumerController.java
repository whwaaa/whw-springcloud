package com.whw.consumer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.whw.consumer.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoverydClient;

    @RequestMapping("/{id}")
    public User queryById(@PathVariable Long id) {
        String url = "http://localhost:9091/user/" + id;
//        ServiceInstance server = discoveryClient.getInstances("user-service").get(0);
//        url = "http://" + server.getHost() + ":" + server.getPort() + "/user/" + id;

        // 负载均衡: 不在通过host和端口访问, 而是直接通过服务名称调用
        url = "http://user-service/user/" + id;

        return restTemplate.getForObject(url, User.class);
    }
}
