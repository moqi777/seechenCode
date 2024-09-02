package com.sv.springbootvue.controller;

import com.sv.springbootvue.pojo.OAdmin;
import com.sv.springbootvue.pojo.Result;
import com.sv.springbootvue.service.OAdminserver;
import com.sv.springbootvue.util.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/30 10:50
 **/
@RestController
@RequestMapping("/oadmin")
public class OAdminController {
    @Autowired
    OAdminserver as;
    @RequestMapping("/login")
    public Result login(@RequestBody OAdmin admin){
        OAdmin login = as.login(admin);
        if (login!=null){
            //登录成功生成token保存
            login.setToken(JwtUtils.createToken());
            return new Result(1,"登录成功",login);
        }
        return new Result(0,"登录失败",login);
    }
    @RequestMapping("/reg")
    public Result reg(@RequestBody OAdmin admin){
        int i = as.reg(admin);
        if (i>0){
            return new Result(1,"注册成功");
        }
        return new Result(0,"注册失败");
    }
}
