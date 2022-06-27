package com.whw.consumer.pojo;

import lombok.Data;

import java.util.Date;

@Data// 消除get/set/toString方法
public class User {

    // id
    private Long id;

    // 用户名
    private String userName;

    // 密码
    private String password;

    // 姓名
    private String name;

    // 年龄
    private String age;

    // 性别 1:男性 2:女性
    private Integer sex;

    // 生日
    private Date birthday;

    // 创建日期
    private Date created;

    // 更新日期
    private Date updated;

    // 备注
    private String Note;
}
