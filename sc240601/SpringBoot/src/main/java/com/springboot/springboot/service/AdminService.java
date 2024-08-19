package com.springboot.springboot.service;

import com.github.pagehelper.PageInfo;
import com.springboot.springboot.pojo.OAdmin;

public interface AdminService {
    OAdmin login(OAdmin a);
    int add(OAdmin a);
    PageInfo<OAdmin> show(Integer pageNum,Integer pageSize);
}
