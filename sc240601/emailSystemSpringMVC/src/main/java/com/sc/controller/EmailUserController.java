package com.sc.controller;

import com.sc.pojo.EmailUser;
import com.sc.service.EmailUserService;
import com.sc.service.impl.EmailUserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:邮箱用户控制层
 * @DateTime:2024/8/3 19:18
 **/
@Controller
@RequestMapping("/emailUser")
public class EmailUserController {
    EmailUserService emailUserService = new EmailUserServiceImpl();
    @RequestMapping("/register")
    public void register(EmailUser emailUser,HttpServletRequest req, HttpServletResponse resp, MultipartFile upImg) throws IOException {
        // 设置内容类型为 HTML，并指定字符编码
        resp.setContentType("text/html;charset=UTF-8");
        //返回0成功；1失败；2用户名已存在；3邮箱已存在
        int i = emailUserService.register(emailUser,upImg,req);
        switch (i){
            case 0:resp.getWriter().print("<script>alert('" + "注册成功" + "');location.href = '/index.jsp';</script>");break;
            case 1:resp.getWriter().print("<script>alert('" + "注册失败" + "');location.href = '/register.jsp';</script>");break;
            case 2:resp.getWriter().print("<script>alert('" + "用户名已存在" + "');location.href = '/register.jsp';</script>");break;
            case 3:resp.getWriter().print("<script>alert('" + "邮箱已存在" + "');location.href = '/register.jsp';</script>");
        }
    }

    @RequestMapping("/login")
    public void login(String username,String password, HttpServletRequest req,HttpServletResponse resp) throws IOException {
        // 设置内容类型为 HTML，并指定字符编码
        resp.setContentType("text/html;charset=UTF-8");
        Object msg = emailUserService.login(username, password);
        if (msg instanceof EmailUser){//如果msg是Emailuser类型说明登录成功
            // 将当前登录的用户信息存在session中
            HttpSession session = req.getSession();
            session.setAttribute("loginUser",msg);
            resp.sendRedirect("/email/selectEmail?fromOrTo=0&index=1");
        }else {//不是的话，那就是String类型，说明登录失败
            resp.getWriter().print("<script>alert('" + msg + "');location.href = '/index.jsp';</script>");
        }
    }

    @RequestMapping("/exit")
    public String exit(HttpServletRequest req){
        //只是对session的操作，无需service层
        req.getSession().removeAttribute("loginUser");
        return "redirect:/index.jsp";
    }
}
