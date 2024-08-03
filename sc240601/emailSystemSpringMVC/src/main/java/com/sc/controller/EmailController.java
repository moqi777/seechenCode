package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/3 16:13
 **/
@Controller
public class EmailController {
    @RequestMapping("/test")
    public void test(){
        System.out.println("test成功");
    }
}
