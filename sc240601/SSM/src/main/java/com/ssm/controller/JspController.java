package com.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:提供转发前端地址的请求
 * @DateTime:2024/8/16 14:12
 **/
@Controller
public class JspController {
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "/login";
    }
    @RequestMapping("/toHome")
    public String toHome(){
        return "/home";
    }
    @RequestMapping("/toIndex")
    public String toIndex(){
        return "/index";
    }
}
