package com.sc.springboottest.server.impl;

import com.sc.springboottest.mapper.OAdminMapper;
import com.sc.springboottest.pojo.OAdmin;
import com.sc.springboottest.server.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/19 18:39
 **/
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    OAdminMapper mapper;

    public OAdmin showById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    public int delById(Integer id) {
        return mapper.deleteByPrimaryKey(id);
    }

    public OAdmin login(OAdmin admin) {
        return mapper.login(admin);
    }
}
