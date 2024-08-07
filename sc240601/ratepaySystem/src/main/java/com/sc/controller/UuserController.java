package com.sc.controller;

import com.sc.pojo.Result;
import com.sc.pojo.Uuser;
import com.sc.service.UuserService;
import com.sc.service.impl.UuserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
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
    @RequestMapping("/toLogin")
    public String toLogin(HttpServletRequest req){
        //做一次判断，如果是已登录状态，跳转进主页
        Uuser loginUuser = (Uuser) req.getSession().getAttribute("loginUuser");
        if (loginUuser!=null) return "redirect:/uuser/toSys";
        return "/jsp/login/loginUI";
    }

    @ResponseBody
    @RequestMapping("/login")
    public Result login(HttpSession session,@RequestBody Uuser uuser) throws IOException {
        Object login = uuserService.login(uuser.getAccount(), uuser.getPassword());
        //返回值为字符串就是失败，字符串里面的内容就是失败信息，返回值是Uuser对象就是成功
        if(login instanceof Uuser){//成功
            session.setAttribute("loginUuser",login);
            System.out.println("进行了一次登录，登录用户为："+login);
            return new Result(1,"登录成功",null);
        }else {
            return new Result(0,(String)login,null );
        }
    }

    @RequestMapping("/toSys")
    public String toSys(){
        return "/jsp/sys/sys";
    }
}
