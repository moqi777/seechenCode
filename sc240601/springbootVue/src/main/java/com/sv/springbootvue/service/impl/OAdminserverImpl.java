package com.sv.springbootvue.service.impl;

import com.sv.springbootvue.mapper.OAdminMapper;
import com.sv.springbootvue.pojo.OAdmin;
import com.sv.springbootvue.service.OAdminserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/30 10:55
 **/
@Service
@Transactional
public class OAdminserverImpl implements OAdminserver {
    @Autowired
    OAdminMapper mapper;
    @Override
    public OAdmin login(OAdmin admin) {
        return mapper.login(admin);
    }

    @Override
    public int reg(OAdmin admin) {
        return mapper.insertSelective(admin);
    }
}
