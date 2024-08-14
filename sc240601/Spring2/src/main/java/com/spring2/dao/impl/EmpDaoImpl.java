package com.spring2.dao.impl;

import com.spring2.dao.EmpDao;
import com.spring2.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 19:53
 **/
@Component
public class EmpDaoImpl implements EmpDao {
    @Override
    public int add(Emp emp) {
        System.out.println("执行了dao层");
        System.out.println(emp);
        return 1;
    }
}
