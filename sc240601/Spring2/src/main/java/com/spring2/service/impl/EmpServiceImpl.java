package com.spring2.service.impl;

import com.spring2.dao.EmpDao;
import com.spring2.pojo.Emp;
import com.spring2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 19:53
 **/
@Component
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpDao empDao;

    @Override
    public int add(Emp emp) {
        System.out.println("执行了service层");
        return empDao.add(emp);
    }
}
