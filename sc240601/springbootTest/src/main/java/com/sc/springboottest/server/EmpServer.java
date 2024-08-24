package com.sc.springboottest.server;

import com.sc.springboottest.pojo.Emp;

import java.util.List;

public interface EmpServer {
    List<Emp> queryAll();
    int delById(Integer id);
    int add(Emp emp);
    int update(Emp emp);
}
