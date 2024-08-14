package com.sc.controller;

import com.github.pagehelper.PageInfo;
import com.sc.pojo.Myuser;
import com.sc.service.UserService;
import com.sc.service.impl.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/13 16:20
 **/
@Controller
public class UserController {
    UserService userService = new UserServiceImpl();
    //前后端不分离：存储作用域
    @RequestMapping("/page")
    public String page(
            @RequestParam(defaultValue = "1") Integer currentIndex,
            @RequestParam(defaultValue = "5") Integer pageSize,
            Map m){
        PageInfo<Myuser> page = userService.page(currentIndex, pageSize);
        m.put("p",page);
        return "/page.jsp";
    }
    //前后端分离：通过json返回result(pageInfo)
    /*
    @RequestMapping("/")
    @ResponseBody
    public Result page2(@RequestParam(defaultValue = "1") Integer currentIndex,
                      @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<User> page = userService.page(currentIndex, pageSize);
        return new Result(1,"分页成功",page);
    }
     */
}
