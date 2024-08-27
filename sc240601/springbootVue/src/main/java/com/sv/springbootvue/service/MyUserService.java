package com.sv.springbootvue.service;

import com.github.pagehelper.PageInfo;
import com.sv.springbootvue.pojo.Myuser;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/27 14:51
 **/
public interface MyUserService {
    public int add(Myuser user);

    public int del(Integer id);

    public int update(Myuser user);

    public Myuser selectById(Integer id);

    public PageInfo<Myuser> selectAll(Integer pageNum,Integer pageSize,Myuser myuser);
}
