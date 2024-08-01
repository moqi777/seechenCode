package com.sc.controller;

import com.sc.pojo.Usermvc;
import com.sc.service.UsermvcService;
import com.sc.service.impl.UsermvcServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

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
    public String add(Usermvc u){
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