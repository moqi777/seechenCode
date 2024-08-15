package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 10:58
 **/
@Repository("ud")
public class UserDaoImpl implements UserDao {
    @Autowired
    User user;

    @Override
    public int login() {
        System.out.println("dao层执行登录sql语句");
        return 0;
    }

    @Override
    public int del() {
        System.out.println("dao层执行删除sql语句");
        return 0;
    }

    @Override
    public int add(User u) {
        System.out.println("dao:"+user);
        System.out.println("执行新增数据库操作");
        return 0;
    }
}
