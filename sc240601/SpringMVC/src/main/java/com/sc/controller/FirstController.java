package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试的控制层
 * @DateTime:2024/7/31 17:43
 **/
@Controller
public class FirstController {
    @RequestMapping("/test")
    public void test(){
        System.out.println("进入测试方法");
    }
    @RequestMapping("/test2")
    public String test2(String name){
        System.out.println("进入测试2方法");
        return "这是我的结果";
    }
}
