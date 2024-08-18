package com.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.mysql.cj.util.DnsSrv;
import com.ssm.pojo.OAdmin;
import com.ssm.pojo.Result;
import com.ssm.service.AdminService;
import com.ssm.util.CodeUtil;
import com.ssm.util.UpDownUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
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
    @Autowired
    UpDownUtil upDownUtil;
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
    @RequestMapping("/exit")
    public String exit(HttpSession session){
        session.removeAttribute("admin");
        return "redirect:/toLogin";
    }
    @RequestMapping("/show")
    public String show(@RequestParam(defaultValue = "1")Integer currentIndex,
                       @RequestParam(defaultValue = "10")Integer pageSize,
                       String conditional,
                       String options,
                       Map map){
        PageInfo<OAdmin> pageInfo = adminService.show(currentIndex,pageSize,conditional,options);
        map.put("p",pageInfo);
        map.put("conditional",conditional);
        map.put("option",options);
        return "/admin/list";
    }
    //验证新增用户姓名是否重复
    @RequestMapping("/checkName")
    @ResponseBody
    public Result checkName(@RequestBody OAdmin admin){
        int i = adminService.checkAccount(admin.getAccount());
        System.out.println(i);
        return new Result(i,null,null);
    }
    //新增用户
    @RequestMapping("/add")
    public String add(OAdmin admin, MultipartFile imgFile,HttpServletRequest req){
        System.out.println(imgFile);
        System.out.println("aaaaaaaaaaa");
        String fileName = upDownUtil.upload(req, imgFile);
        admin.setHeadPic(fileName);
        admin.setCreatetime(new Date());
        adminService.add(admin);
        return "redirect:/admin/show";
    }
    //删除用户
    @RequestMapping("/del")
    public String del(Integer[] ids,Integer currentIndex){
        adminService.del(ids);
        return "redirect:/admin/show?currentIndex="+currentIndex;
    }
    //启动用户
    @RequestMapping("/startUsing")
    public String disabledel(Integer[] ids,Integer currentIndex){
        adminService.startUsing(ids);
        return "redirect:/admin/show?currentIndex="+currentIndex;
    }
    //禁用用户
    @RequestMapping("/disable")
    public String disable(Integer[] ids,Integer currentIndex){
        adminService.disable(ids);
        return "redirect:/admin/show?currentIndex="+currentIndex;
    }
}
