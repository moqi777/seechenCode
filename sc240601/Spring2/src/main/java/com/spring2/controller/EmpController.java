package com.spring2.controller;

import com.spring2.pojo.Emp;
import com.spring2.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 19:52
 **/
@Controller
public class EmpController {
    @Autowired
    EmpService es;
    @RequestMapping("/add")
    public String add(Emp emp){
        System.out.println("进入到控制层执行");
        es.add(emp);
        return "/index.jsp";
    }
}
