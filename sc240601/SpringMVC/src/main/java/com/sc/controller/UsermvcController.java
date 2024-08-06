package com.sc.controller;

import com.sc.pojo.Usermvc;
import com.sc.service.UsermvcService;
import com.sc.service.impl.UsermvcServiceImpl;
import com.sc.util.PageInfo;
import com.sc.util.UpDownUtil;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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
    //改分页 搜索 查询
    @RequestMapping("/show")
    public String show(HttpSession session,Map map, Integer currentIndex, Integer pageSize){
        //处理分页请求
        if (currentIndex==null) currentIndex=1;//第一次使用
        //如果传递过来了pageSize 存储起来
        //如果下一页过来 先获取是否存储过pageSize
        //如果没有值 才设置默认3
        if(pageSize!=null){//一定传了值
            session.setAttribute("pageSize",pageSize);
        }else {//没有传值
            pageSize = (Integer) session.getAttribute("pageSize");
            if (pageSize==null) pageSize=3;
        }
        //调用业务层service() 实现分页业务
        PageInfo<Usermvc> p = us.show(currentIndex, pageSize);
        map.put("p",p);
        return "forward:/day1/show.jsp";
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> dowmload(String fileName,HttpServletRequest req) throws IOException {
        return UpDownUtil.download(fileName,req);
    }
}
// <a href="/项目前缀/请求前缀/add"></a>