package com.sc.springboottest.server.impl;

import com.sc.springboottest.mapper.EmpMapper;
import com.sc.springboottest.pojo.Emp;
import com.sc.springboottest.server.EmpServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/24 9:19
 **/
@Service
@Transactional
public class EmpServerImpl implements EmpServer {
    @Autowired
    EmpMapper mapper;
    @Override
    public List<Emp> queryAll() {
        return mapper.selectAll();
    }

    @Override
    public int delById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int add(Emp emp) {
        emp.setHiredate(new Date());
        return mapper.insert(emp);
    }

    @Override
    public int update(Emp emp) {
        return mapper.updateByPrimaryKeySelective(emp);
    }
}
