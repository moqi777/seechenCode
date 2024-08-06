package com.sc.service;

import com.sc.pojo.Usermvc;
import com.sc.util.PageInfo;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:处理用户模块业务
 * @DateTime:2024/8/1 16:59
 **/
public interface UsermvcService {
    //1.新增用户
    public int add(Usermvc u);
    //2.查询最新数据（参数：前端能给什么就写什么）
    //返回值：前端需要什么返回就给什么
    public PageInfo<Usermvc> show(int currentIndex, int pageSize);
    public boolean checkName(String name);
}
