package com.sc.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/18 15:53
 **/
//测试 在代码中是否可以 获取nacos配置中心的配置
@RestController
@RefreshScope//刷新作用域 动态捕获配置中心修改的配置
public class ConfigController {
    @Value("${user.username}")
    String un;
    @Value("${user.password}")
    String pw;
    @RequestMapping("/getAdmin")
    public String getAdmin(){
        return "获取数据：账号-"+un+"，密码-"+pw;
    }
}
