package com.springboot.springboot.controller;

import com.github.pagehelper.PageInfo;
import com.springboot.springboot.pojo.OAdmin;
import com.springboot.springboot.pojo.Result;
import com.springboot.springboot.service.AdminService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/19 14:58
 **/
//前后端分离的项目 处理的前后的结果都是json
@RestController
// @CrossOrigin //跨域注解 不推荐 不灵活 每个类都要加
public class AdminController {
    //1.定义日志对象
    private static final Logger LOG = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    AdminService as;

    public void setAs(AdminService as) {
        this.as = as;
    }

    @RequestMapping("/testLog")
    public Result testLog(Integer num){
        //2.通过LOG对象.方法() 添加日志
        LOG.debug("开始进入testLog方法，执行请求处理");
        LOG.info("开始处理中...");
        LOG.warn("接收到了参数："+num+"，可能会有问题");
        try {
            int result = 10/num;
        }catch (Exception E){
            LOG.error("分母为0了");
        }
        return new Result(1,"成功",null);
    }

    @RequestMapping("/login")
    public Result login(OAdmin a){
        OAdmin admin = as.login(a);
        if (admin!=null){
            return new Result(1,"登录成功",admin);
        }
        return new Result(0,"登录失败",null);
    }
    @RequestMapping("/add")
    public Result add(@RequestBody OAdmin a){
        int i = as.add(a);
        if (i>0){
            return new Result(1,"新增成功",null);
        }
        return new Result(0,"新增失败",null);
    }
    @RequestMapping("/show")
    public Result show(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "5") Integer pageSize){
        PageInfo<OAdmin> p = as.show(pageNum,pageSize);
        return new Result(1,"分页成功",p);
    }
}
