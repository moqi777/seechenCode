package com.sc.kuaizilive.server.impl;

import com.sc.kuaizilive.mapper.*;
import com.sc.kuaizilive.pojo.Khouse;
import com.sc.kuaizilive.server.KhouseServer;
import com.sc.kuaizilive.util.UpdownUtilSpringBoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/6 15:23
 **/
@Service
@Transactional
public class KhouseServerImpl implements KhouseServer {
    @Autowired
    KUserMapper kUserMapper;
    @Autowired
    KhouseMapper khouseMapper;
    @Autowired
    KhousePropertyMapper khousePropertyMapper;
    @Autowired
    KhouseContactMapper khouseContactMapper;
    @Autowired
    KhouseImgMapper khouseImgMapper;

    public void addIssue1(Khouse khouse, MultipartFile[] files, HttpServletRequest req) {
        //先上传头像
        List<String> imgs = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                // 一个文件上传工具类
                imgs.add(UpdownUtilSpringBoot.upload(req,file));
            }
        }
        //先存进房产详情表，新增后主键ID已经存入khouse.property
        khousePropertyMapper.insertSelective(khouse.getProperty());
        //存联系信息表
        khouseContactMapper.insertSelective(khouse.getContact());
        //存图片表
        khouseImgMapper.inserts(imgs,khouse.getPropertyId());
        //存主表
        //先根据账号用户名查询账号ID
        Integer userId = kUserMapper.selectByUserName(khouse.getUser().getUserName()).getUserId();
        khouse.setAccountId(userId);
        //设置审核状态为 0待审核
        khouse.setStatus(0);
        //开始存主表
        khouseMapper.insertSelective(khouse);
    }

    public void addIssue2(Khouse khouse) {
        //先存进房产详情表，新增后主键ID已经存入khouse.property
        khousePropertyMapper.insertSelective(khouse.getProperty());
        //存联系信息表
        khouseContactMapper.insertSelective(khouse.getContact());
        //存主表
        //先根据账号用户名查询账号ID
        Integer userId = kUserMapper.selectByUserName(khouse.getUser().getUserName()).getUserId();
        khouse.setAccountId(userId);
        //设置审核状态为 0待审核
        khouse.setStatus(0);
        //开始存主表
        khouseMapper.insertSelective(khouse);
    }

    public void addIssue3(Khouse khouse) {
        //先存进房产详情表，新增后主键ID已经存入khouse.property
        khousePropertyMapper.insertSelective(khouse.getProperty());
        //存联系信息表
        khouseContactMapper.insertSelective(khouse.getContact());
        //存主表
        //先根据账号用户名查询账号ID
        Integer userId = kUserMapper.selectByUserName(khouse.getUser().getUserName()).getUserId();
        khouse.setAccountId(userId);
        //设置审核状态为 0待审核
        khouse.setStatus(0);
        //开始存主表
        khouseMapper.insertSelective(khouse);
    }

    public void addIssue4(Khouse khouse, MultipartFile[] files, HttpServletRequest req) {
        //先上传头像
        List<String> imgs = new ArrayList<>();
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                // 一个文件上传工具类
                imgs.add(UpdownUtilSpringBoot.upload(req,file));
            }
        }
        //先存进房产详情表，新增后主键ID已经存入khouse.property
        khousePropertyMapper.insertSelective(khouse.getProperty());
        //存联系信息表
        khouseContactMapper.insertSelective(khouse.getContact());
        //存图片表
        khouseImgMapper.inserts(imgs,khouse.getPropertyId());
        //存主表
        //先根据账号用户名查询账号ID
        Integer userId = kUserMapper.selectByUserName(khouse.getUser().getUserName()).getUserId();
        khouse.setAccountId(userId);
        //设置审核状态为 0待审核
        khouse.setStatus(0);
        //开始存主表
        khouseMapper.insertSelective(khouse);
    }
}
