package com.sc.service;

import com.sc.pojo.Usermvc;

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
    //2.查询最新数据
    public List<Usermvc> show();
}
