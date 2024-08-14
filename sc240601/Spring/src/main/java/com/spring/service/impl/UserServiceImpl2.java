package com.spring.service.impl;

import com.spring.dao.UserDao;
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
 * @DateTime:2024/8/14 16:13
 **/
//第二种业务
//管理员方式做业务
@Service("us2")
public class UserServiceImpl2 implements UserService {
    // @Autowired
    @Resource
    UserDao ud;
    public int add(User u) {
        System.out.println("执行另一个新增业务");
        ud.add(u);
        return 0;
    }
}
