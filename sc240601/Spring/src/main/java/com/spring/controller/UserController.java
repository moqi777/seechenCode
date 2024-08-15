package com.spring.controller;

import com.spring.pojo.User;
import com.spring.service.UserService;
import com.spring.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 10:56
 **/
//默认id：类名首字母小写 也可以自行修改
@Controller("uc")
public class UserController {
    // @Qualifier("us1")//指定bean的id进行注入
    // @Resource(name = "us1")
    @Autowired
    UserService us1;//spring创建对象赋值

    @Autowired
    User user;

    @RequestMapping("/add")
    public String add(User u){
        System.out.println("controller："+user);
        System.out.println("执行新增请求");
        //调用us中方法
        int i = us1.add(u);
        System.out.println(u);
        return "/home.jsp";//模拟的
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("控制层处理登录请求");
        us1.login();
        return "/home.jsp";
    }

    @RequestMapping("/del")
    public String del(){
        System.out.println("控制层处理删除请求");
        us1.del();
        return "/home.jsp";
    }
}
