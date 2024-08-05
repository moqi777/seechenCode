package com.sc.controller;

import com.sc.pojo.Uuser;
import com.sc.service.UuserService;
import com.sc.service.impl.UuserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
    @RequestMapping("/login")
    public void login(HttpSession session, HttpServletResponse resp,String name, String pwd) throws IOException {
        //设置返回页面为html，因为你要通过js返回一个alert()
        resp.setContentType("text/html;charset=UTF-8");
        Object login = uuserService.login(name, pwd);
        //返回值为字符串就是失败，字符串里面的内容就是失败信息，返回值是Uuser对象就是成功
        if(login instanceof Uuser){//成功
            session.setAttribute("loginUuser",login);
            System.out.println("进行了一次登录，登录用户为："+login);
            resp.getWriter().print("<script>alert('" + "登录成功" + "');location.href = '/jsp/sys/sys.jsp';</script>");
        }else {
            resp.getWriter().print("<script>alert('" + login + "');location.href = '/jsp/login/loginUI.jsp';</script>");
        }
    }
}
