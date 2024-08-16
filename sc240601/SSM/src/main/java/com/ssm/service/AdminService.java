package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.OAdmin;

public interface AdminService {
    //登录业务
    OAdmin login(OAdmin admin);
    //查询分页业务
    PageInfo<OAdmin> show(Integer currentIndex,Integer pageSize,OAdmin admin);
    //新增业务
    int add(OAdmin admin);
}
