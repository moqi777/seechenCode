package com.sc.controller;

import com.sc.pojo.Huser;
import com.sc.service.HuserService;
import com.sc.service.impl.HuserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/8 19:53
 **/
@Controller
@RequestMapping("/huser")
public class HuserController {
    HuserService huserService = new HuserServiceImpl();
    @RequestMapping("/toShow")
    public String toShow(HttpServletRequest req){
        List<Huser> list = huserService.selectAll();
        req.setAttribute("list",list);
        return "/show";
    }

    @RequestMapping("/add")
    public String add(Huser huser){
        huser.setCreatetime(new Date());
        huserService.insertHuser(huser);
        return "redirect:/huser/toShow";
    }

    @RequestMapping("/del")
    public String del(int[] check){
        huserService.delHuserByIds(check);
        return "redirect:/huser/toShow";
    }
}
