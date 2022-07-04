package com.whw.client.fallback;

import com.whw.client.UserClient;
import com.whw.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {

    // 实现刚才编写的UserFeignClient，作为fallback的处理类, 方法是fallback的处理方法
    @Override
    public User queryById(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("网络拥堵,用户异常");
        return user;
    }
}
