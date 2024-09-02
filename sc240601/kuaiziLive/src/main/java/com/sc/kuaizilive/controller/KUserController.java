package com.sc.kuaizilive.controller;

import com.sc.kuaizilive.pojo.KUser;
import com.sc.kuaizilive.pojo.Result;
import com.sc.kuaizilive.server.KUserServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/2 15:25
 **/
@RestController
@RequestMapping("/kuser")
public class KUserController {
    @Autowired
    KUserServer us;
    //获取验证码
    @RequestMapping("/getCode")
    public Result getCode(){
        Integer code = us.getCode();
        return new Result(1,"获取验证码成功",code);
    }
    @RequestMapping("/codeLogin")
    public Result codeLogin(@RequestBody KUser user){
        KUser kUser = us.codeLogin(user);
        if (kUser!=null){
            return new Result(1,"登录成功",kUser);
        }
        return new Result(0,"登录失败");
    }
}
