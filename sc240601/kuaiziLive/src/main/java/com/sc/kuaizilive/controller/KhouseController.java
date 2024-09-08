package com.sc.kuaizilive.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sc.kuaizilive.pojo.Khouse;
import com.sc.kuaizilive.pojo.Result;
import com.sc.kuaizilive.server.impl.KhouseServerImpl;
import com.sc.kuaizilive.util.UpdownUtilSpringBoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/6 15:22
 **/
@RestController
@RequestMapping("/khouse")
public class KhouseController {
    @Autowired
    KhouseServerImpl server;
    @Resource
    ObjectMapper objectMapper;
    @RequestMapping("/addIssue1")
    public Result addIssue1(
            @RequestParam("house") String house,
            @RequestParam("files[]")MultipartFile[] files,
            HttpServletRequest req) throws JsonProcessingException {
        // 解析 JSON 字符串为 Khouse 对象
        Khouse khouse = objectMapper.readValue(house, Khouse.class);
        server.addIssue1(khouse, files, req);
        System.out.println("地址："+UpdownUtilSpringBoot.getPath());
        return new Result(1,"发布成功");
    }
    @RequestMapping("/addIssue2")
    public Result addIssue2(@RequestBody Khouse house){
        server.addIssue2(house);
        return new Result(1,"发布成功");
    }
    @RequestMapping("/addIssue3")
    public Result addIssue3(@RequestBody Khouse house){
        server.addIssue3(house);
        return new Result(1,"发布成功");
    }
    @RequestMapping("/addIssue4")
    public Result addIssue4(
            @RequestParam("house") String house,
            @RequestParam("files[]")MultipartFile[] files,
            HttpServletRequest req) throws JsonProcessingException {
        // 解析 JSON 字符串为 Khouse 对象
        Khouse khouse = objectMapper.readValue(house, Khouse.class);
        server.addIssue4(khouse, files, req);
        System.out.println("地址："+UpdownUtilSpringBoot.getPath());
        return new Result(1,"发布成功");
    }
}
