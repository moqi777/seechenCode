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
@Service("us1")
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
        //批量删除redis多个key值 通过keys命令 写正则来匹配多个key
        redis.delete(redis.keys("user-*"));
        return mapper.insertSelective(user);
    }

    @Override
    public int del(Integer id) {
        // redis.delete("user-"+id);
        redis.delete(redis.keys("user-*"));
        return mapper.deleteByPrimaryKey(id);
    }

    @Override
    public Myuser update(Myuser user) {
        // redis.delete("user-"+user.getId());
        redis.delete(redis.keys("user-*"));
        mapper.updateByPrimaryKeySelective(user);
        return mapper.selectByPrimaryKey(user.getId());
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
        PageInfo<Myuser> p = (PageInfo<Myuser>) redis.opsForValue().get("user-"+pageNum+"-"+pageSize);
        if (p==null){
            PageHelper.startPage(pageNum,pageSize);
            p = new PageInfo<>(mapper.selectLimit(myuser));
            redis.opsForValue().set("user-"+pageNum+"-"+pageSize,p);
        }
        return p;
    }
}
