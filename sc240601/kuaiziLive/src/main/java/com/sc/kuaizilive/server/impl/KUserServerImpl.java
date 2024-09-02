package com.sc.kuaizilive.server.impl;

import com.sc.kuaizilive.mapper.KUserMapper;
import com.sc.kuaizilive.pojo.KUser;
import com.sc.kuaizilive.server.KUserServer;
import com.sc.kuaizilive.util.GenerateUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/2 15:30
 **/
@Service
@Transactional
public class KUserServerImpl implements KUserServer {
    @Autowired
    KUserMapper mapper;

    public Integer getCode() {
        //虚拟一个4位验证码输出在控制条
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        System.out.println(randomNumber);//输出在控制台
        return randomNumber;
    }

    public KUser codeLogin(KUser user) {
        //先判断是登录还是注册，判断用户是否存在
        KUser byPhoneUser = mapper.selectByPhone(user.getUserPhone());
        //如果存在直接返回
        if (byPhoneUser!=null) return byPhoneUser;
        //不存在开始注册
        //系统分配用户名
        user.setUserName(GenerateUsername.getUsername());
        user.setCreateTime(new Date());
        //存入数据库
        int i = mapper.insertSelective(user);
        if (i==1) return user;
        return null;
    }
}
