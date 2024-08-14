package com.spring.dao.impl;

import com.spring.dao.UserDao;
import com.spring.pojo.User;
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
    @Override
    public int add(User u) {
        System.out.println("执行新增数据库操作");
        return 0;
    }
}
