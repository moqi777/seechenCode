package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.ssm.pojo.OAdmin;
import com.ssm.service.AdminService;
import com.ssm.util.CodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/16 14:28
 **/
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    //生成验证码的请求
    @RequestMapping("/getCode")
    public void getCode(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CodeUtil.processRequest(req,resp);
        String code = (String)req.getSession().getAttribute("randomCode");
        System.out.println(code);
    }
    @RequestMapping("/login")
    public String login(OAdmin admin, String code, HttpSession session){
        String randomCode = (String)session.getAttribute("randomCode");
        if (randomCode.equalsIgnoreCase(code)){
            //调用业务层验证账号密码
            OAdmin oAdmin = adminService.login(admin);
            if (oAdmin!=null){//登录成功
                session.setAttribute("admin",oAdmin);
                return "redirect:/toHome";
            }
        }
        return "redirect:/toLogin";
    }
    @RequestMapping("/show")
    public String show(@RequestParam(defaultValue = "1")Integer currentIndex,
                       @RequestParam(defaultValue = "5")Integer pageSize,
                       Map map){
        PageInfo<OAdmin> pageInfo = adminService.show(currentIndex,pageSize,null);
        map.put("p",pageInfo);
        return "/admin/list";
    }
}
