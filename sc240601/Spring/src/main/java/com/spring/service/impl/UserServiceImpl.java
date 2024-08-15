package com.spring.service.impl;

import com.spring.dao.UserDao;
import com.spring.dao.impl.UserDaoImpl;
import com.spring.pojo.User;
import com.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 10:57
 **/
//普通用户业务层
@Service("us1")
public class UserServiceImpl implements UserService {
    // @Autowired
    @Resource
    UserDao ud;//spring创建对象赋值

    @Override
    public int login() {
        System.out.println("业务层处理登录功能");
        int c=1/0;//发生异常了 有异常通知没有后置通知
        ud.login();
        return 0;
    }

    @Override
    public int del() {
        System.out.println("业务层处理删除该功能");
        ud.del();
        return 0;
    }

    @Autowired
    User user;

    public int add(User u) {
        System.out.println("service："+user);
        System.out.println("执行新增业务功能");
        int i = ud.add(u);
        return 0;
    }
}
