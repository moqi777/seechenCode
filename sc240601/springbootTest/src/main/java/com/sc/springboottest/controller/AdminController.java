package com.sc.springboottest.controller;

import com.sc.springboottest.pojo.OAdmin;
import com.sc.springboottest.pojo.Result;
import com.sc.springboottest.server.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/19 18:38
 **/
@RestController
public class AdminController {
    @Autowired
    AdminService adminService;
    @RequestMapping("/login")
    public Result login(OAdmin a){
        OAdmin admin = adminService.login(a);
        if (admin!=null){
            return new Result(1,"登录成功",admin);
        }
        return new Result(0,"登录失败",null);
    }
    @RequestMapping("/showById")
    public Result showById(@RequestBody OAdmin a){
        OAdmin admin = adminService.showById(a.getId());
        return new Result(admin==null?0:1,admin==null?"查询失败":"查询成功",admin);
    }
    @RequestMapping("/delById")
    public Result delById(@RequestBody OAdmin a){
        int i = adminService.delById(a.getId());
        return new Result(i,i==1?"删除成功":"删除失败",null);
    }
}
