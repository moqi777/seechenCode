package com.sv.springbootvue.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sv.springbootvue.mapper.MyuserMapper;
import com.sv.springbootvue.pojo.Myuser;
import com.sv.springbootvue.service.MyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/12 11:22
 **/
//通过redis注解实现
@Service("us2")
public class MyUserServiceImpl2 implements MyUserService {
    @Autowired
    MyuserMapper mapper;

    public int dels(List<Myuser> myusers) {
        return mapper.deleteByIds(myusers);
    }
    @CacheEvict(value = "user::*")
    public int add(Myuser user) {
        return mapper.insertSelective(user);
    }
    @CacheEvict(cacheNames = "user",key = "#id")
    public int del(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }
    //把方法的返回值更新到指定的redis数据中去
    @CachePut(cacheNames = "user",key = "#user.id")
    public Myuser update(Myuser user) {
        mapper.updateByPrimaryKeySelective(user);
        return mapper.selectByPrimaryKey(user.getId());
    }
    //如果不加注解参数 自动生成key的规则是特别复杂的
    //cacheNames：缓存的名字 默认cacheNames::key 作为存储redis的key
    //key：可以随便写 也可以写方法的参数 #id #u.id
    @Cacheable(cacheNames = "user",key = "#id")
    public Myuser selectById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }
    @Cacheable(cacheNames = "user",key = "#pageNum+#pageSize")
    public PageInfo<Myuser> selectAll(Integer pageNum, Integer pageSize, Myuser myuser) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(mapper.selectLimit(myuser));
    }
}
