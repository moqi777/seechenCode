package com.sc.login.controller;

import com.sc.login.config.RestTemplateConfig;
import com.sc.login.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/13 20:14
 **/
@RestController
public class LoginController {
    @Autowired
    RestTemplate rt;

    @RequestMapping("/login")
    public Result login(String pw){
        if ("123".equals(pw)){
            System.out.println("登录成功");
            Result viewResult = rt.getForObject("http://view-service/view", Result.class);
            return new Result(1,"登录成功，"+viewResult.getMsg());
        }else {
            System.out.println("登录失败");
            return new Result(0,"密码错误");
        }
    }
}
