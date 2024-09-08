package com.sc.kuaizilive.controller;

import com.sc.kuaizilive.mapper.KUserMapper;
import com.sc.kuaizilive.pojo.KUser;
import com.sc.kuaizilive.server.KUserServer;
import org.junit.jupiter.api.Test;

import javax.annotation.Resource;

class KUserControllerTest {
    @Resource
    KUserServer us;

    KUserMapper mapper;

    @Test
    public void codeLogin(){
        KUser kUser = new KUser();
        kUser.setUserPhone("13479394730");
        kUser.setAreacode("+86");
        KUser kUser1 = us.codeLogin(kUser);
        System.out.println(kUser1);
    }

    @Test
    public void test(){
        KUser kUser = mapper.selectByPhone("123");

    }
}