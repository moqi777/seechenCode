package com.sv.springbootvue.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sv.springbootvue.mapper.MyuserMapper;
import com.sv.springbootvue.pojo.Myuser;
import com.sv.springbootvue.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    RedisTemplate<String,Object> redis;//连接redis
    //假设通过redis实现缓存的功能
    //1.查询：第一次查 Mysql 保存redis 第二次查redis
    //2.增 删 改：清空redis之前存储的相关数据 防止脏读

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
        Myuser user = (Myuser) redis.opsForValue().get("user-"+id);
        if (user==null){
            user = mapper.selectByPrimaryKey(id);
            redis.opsForValue().set("user-"+id,user);
        }
        return user;
    }

    @Override
    public PageInfo<Myuser> selectAll(Integer pageNum, Integer pageSize, Myuser myuser) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(mapper.selectLimit(myuser));
    }
}
