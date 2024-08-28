package com.sv.springbootvue.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sv.springbootvue.mapper.MyuserMapper;
import com.sv.springbootvue.pojo.Myuser;
import com.sv.springbootvue.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/27 14:52
 **/
@Service
@Transactional
public class MyUserServiceImpl implements MyUserService {
    @Autowired
    MyuserMapper mapper;

    @Override
    public int dels(List<Myuser> myusers) {
        return mapper.deleteByIds(myusers);
    }

    @Override
    public int add(Myuser user) {
        return mapper.insertSelective(user);
    }

    @Override
    public int del(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Myuser user) {
        return mapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Myuser selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public PageInfo<Myuser> selectAll(Integer pageNum, Integer pageSize, Myuser myuser) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(mapper.selectLimit(myuser));
    }
}
