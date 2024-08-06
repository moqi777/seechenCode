package com.sc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/6 10:27
 **/
@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/login")
    public String login(){
        System.out.println("进入登录功能");
        //调用service控制
        Random r = new Random();
        int n = r.nextInt(2);
        if (n==1){//失败
            return "redirect:/index.jsp";
        }else {
            return "redirect:/user/toShow";
        }
    }
    @RequestMapping("toShow")
    public String toshow(){
        //视图解析器处理好了共同的前缀和后缀
        //前缀 /WEB-INF/jsp
        //后缀 .jsp
        return "/user/show";
    }
    @RequestMapping("toAdd")
    public String toAdd(){
        return "/user/add";
    }
    @RequestMapping("toUpdate")
    public String toUpdate(){
        return "/user/update";
    }
}
