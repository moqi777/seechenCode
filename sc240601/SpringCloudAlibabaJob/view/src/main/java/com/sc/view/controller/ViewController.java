package com.sc.view.controller;

import com.sc.view.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/13 20:18
 **/
@RestController
public class ViewController {
    @Value("${server.port}")
    int port;
    @RequestMapping("/view")
    public Result view(){
        System.out.println("展示数据");
        return new Result(1,"数据数据："+port);
    }
}
