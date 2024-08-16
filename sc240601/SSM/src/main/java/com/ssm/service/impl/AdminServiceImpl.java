package com.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ssm.mapper.OAdminMapper;
import com.ssm.pojo.OAdmin;
import com.ssm.service.AdminService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/16 14:49
 **/
@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Autowired
    OAdminMapper mapper;
    public OAdmin login(OAdmin admin) {
        return mapper.login(admin);
    }

    public PageInfo<OAdmin> show(Integer currentIndex, Integer pageSize, OAdmin admin) {
        PageHelper.startPage(currentIndex,pageSize);
        return new PageInfo<>(mapper.show(admin));
    }

    public int add(OAdmin admin) {
        return mapper.insertSelective(admin);
    }
}
