package com.ssm.service;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.OAdmin;

public interface AdminService {
    //登录业务
    OAdmin login(OAdmin admin);
    //查询分页业务
    PageInfo<OAdmin> show(Integer currentIndex,Integer pageSize,String conditional,String options);
    //新增业务
    int add(OAdmin admin);
    //验证用户名是否重复
    int checkAccount(String account);
    //删除所选id的用户
    void del(Integer[] ids);
    //将所选id的用户设置为启用
    void startUsing(Integer[] ids);
    //将所选id的用户设置为禁用
    void disable(Integer[] ids);
}
