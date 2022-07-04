package com.whw.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(value = "/consumer")
@DefaultProperties(defaultFallback = "defaultFallback")// 默认的降级服务方法名
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping(value = "/{id}")
    @HystrixCommand// 启动服务降级
    public String queryById(@PathVariable(value = "id") Long id) {

        // 测试熔断器
        if (id == 0L)
            throw new RuntimeException("手动抛出异常,阻塞请求");

        String url;

        // 未启用ribbon的配置
        //ServiceInstance instance = discoveryClient.getInstances("user-service").get(0);
        //url = "http://" + instance.getHost() + ":" + instance.getPort() + "/user/" + id;

        // 启用ribbon的配置
        url = "http://user-service/user/" + id;

        return restTemplate.getForObject(url, String.class);
    }

    public String defaultFallback() {
        return "对不起, 网络拥堵!";
    }
}

