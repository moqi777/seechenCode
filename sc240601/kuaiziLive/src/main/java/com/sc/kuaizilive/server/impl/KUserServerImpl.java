package com.sc.kuaizilive.server.impl;

import com.sc.kuaizilive.mapper.KUserMapper;
import com.sc.kuaizilive.pojo.KUser;
import com.sc.kuaizilive.pojo.Result;
import com.sc.kuaizilive.server.KUserServer;
import com.sc.kuaizilive.util.GenerateUsername;
import com.sc.kuaizilive.util.JwtUtils;
import com.sc.kuaizilive.util.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Random;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/2 15:30
 **/
@Service
@Transactional
public class KUserServerImpl implements KUserServer {
    @Autowired
    KUserMapper mapper;

    public Integer getCode() {
        //虚拟一个4位验证码输出在控制条
        Random random = new Random();
        int randomNumber = 1000 + random.nextInt(9000);
        System.out.println(randomNumber);//输出在控制台
        return randomNumber;
    }

    public Result pwLogin(KUser user) {
        //先判断用户是否存在
        KUser kUser = mapper.selectByPhone(user.getUserPhone());
        //对用户传来的密码进行MD5加密以用于校验
        String md5Code = MD5.MD5Code(user.getPassword());
        if (kUser==null){
            return new Result(0,"用户不存在");
        }else if (!md5Code.equals(kUser.getPassword())){
            return new Result(0,"密码错误");
        }
        //登录成功生成token保存
        kUser.setToken(JwtUtils.createToken());
        return new Result(1,"登录成功",kUser);
    }

    public Result updatePw(KUser user) {
        //先判断用户是否存在
        KUser kUser = mapper.selectByPhone(user.getUserPhone());
        if (kUser==null){
            //给密码加密
            user.setPassword(MD5.MD5Code(user.getPassword()));
            //用户不存在就创建一个
            KUser kUser1 = codeLogin(user);
            //然后返回给前端并告诉是注册了一个用户
            return new Result(1,"用户不存在，已注册");
        }
        //用户存在，修改密码
        //对密码进行md5加密
        String md5Code = MD5.MD5Code(user.getPassword());
        kUser.setPassword(md5Code);
        int i = mapper.updateByPrimaryKeySelective(kUser);
        if (i==0){
            return new Result(0,"修改失败");
        }else {
            return new Result(1,"修改成功");
        }
    }

    public KUser codeLogin(KUser user) {
        //先判断是登录还是注册，判断用户是否存在
        KUser byPhoneUser = mapper.selectByPhone(user.getUserPhone());
        //如果存在直接返回
        if (byPhoneUser!=null) return byPhoneUser;
        //不存在开始注册
        //系统分配用户名
        user.setUserName(GenerateUsername.getUsername());
        user.setCreateTime(new Date());
        //将用户标记为普通用户
        user.setType(0);
        //给一个默认头像
        user.setHead("/user/头像.jpg");
        //存入数据库
        int i = mapper.insertSelective(user);
        if (i==1) return user;
        return null;
    }


}
