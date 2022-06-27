package com.whw.user.pojo;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;// https://blog.csdn.net/maoyuanming0806/article/details/78011700
                      // sql.Date只有日期部分


@Data// 消除get/set/toString方法
@Table(name = "tb_user")
public class User {

    // id
    @Id// 标识是主键id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 指定配置列的增量 1.https://blog.csdn.net/weixin_42131342/article/details/114713122
    //               2.https://blog.csdn.net/tree_java/article/details/71158122
    // GenerationType.TABLE: 使用一个特定的数据库表格来保存主键。
    // GenerationType.SEQUENCE: 根据底层数据库的序列来生成主键，条件是数据库支持序列。
    // GenerationType.IDENTITY: 主键由数据库自动生成（主要是自动增长型）
    // GenerationType.AUTO: 主键由程序控制。
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
