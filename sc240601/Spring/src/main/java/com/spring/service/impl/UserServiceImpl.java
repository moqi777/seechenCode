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

    public int add(User u) {
        System.out.println("执行新增业务功能");
        int i = ud.add(u);
        return 0;
    }
}
