package com.springboot.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springboot.springboot.mapper.OAdminMapper;
import com.springboot.springboot.pojo.OAdmin;
import com.springboot.springboot.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/19 15:07
 **/
@Service
// @Transactional   //springboot会自动添加 可以省略
public class AdminServiceImpl implements AdminService {
    //mapper会报红，但是他是允许的 有由于是用@MapperScan来做整合的
    //但是程序不运行 它不认为 你现在有这个Bean对象存在
    //如果觉得不想这样可以在mapper接口上加上一个@Repository注解(可有可无)
    @Autowired
    OAdminMapper mapper;
    public OAdmin login(OAdmin a) {
        return mapper.login(a);
    }

    public int add(OAdmin a) {
        return mapper.insertSelective(a);
    }

    public PageInfo<OAdmin> show(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return new PageInfo<>(mapper.show());
    }
}
