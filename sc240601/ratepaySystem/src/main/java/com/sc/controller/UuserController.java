package com.sc.controller;

import com.sc.pojo.Uuser;
import com.sc.service.UuserService;
import com.sc.service.impl.UuserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/5 20:45
 **/
@Controller
@RequestMapping("/uuser")
public class UuserController {
    UuserService uuserService = new UuserServiceImpl();

    //用于在访问根目录访问index重定向到这个请求后转发到WEB-INF内登录页面
    @RequestMapping("toLogin")
    public String toLogin(){
        return "/jsp/login/loginUI";
    }

    @ResponseBody
    @RequestMapping("/login")
    public String login(HttpSession session, HttpServletResponse resp,String account, String password) throws IOException {
        Object login = uuserService.login(account, password);
        //返回值为字符串就是失败，字符串里面的内容就是失败信息，返回值是Uuser对象就是成功
        if(login instanceof Uuser){//成功
            session.setAttribute("loginUuser",login);
            System.out.println("进行了一次登录，登录用户为："+login);
            resp.sendRedirect("redirect:/uuser/toSys");
            return null;
        }else {
            return (String) login;
        }
    }

    @RequestMapping("toSys")
    public String toSys(){
        return "/jsp/sys/sys";
    }
}
