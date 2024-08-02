package com.sc.controller;

import com.sc.pojo.Usermvc;
import com.sc.service.UsermvcService;
import com.sc.service.impl.UsermvcServiceImpl;
import com.sc.util.UpDownUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/1 16:47
 **/
@Controller //标注控制层
@RequestMapping("/usermvc")   //请求前缀 是为了防止不同模块可能重名请求
public class UsermvcController {
    UsermvcService us = new UsermvcServiceImpl();
    @RequestMapping("/add")
    public String add(HttpServletRequest req,Usermvc u, MultipartFile myhead) throws IOException {
        String newName = UpDownUtil.upload(req, myhead);
        //用户对象头像存储地址(前后端不分离 推荐存储文件名字即可)
        //前后端分离了 推荐存储完整地址 ip地址/XXX.jpg
        u.setHead(newName);
        //调用service
        int i = us.add(u);
        if (i>0){
            //适合冲定向
            return "redirect:/usermvc/show";
        }
        return "redirect:/day1/add.jsp";
    }
    //show请求 查询最新数据 存储作用域返回show.jsp
    @RequestMapping("/show")
    public String show(Map map){
        List<Usermvc> show = us.show();
        map.put("list",show);
        return "/day1/show.jsp";
    }
}
// <a href="/项目前缀/请求前缀/add"></a>