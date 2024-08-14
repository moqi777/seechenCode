package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.pojo.Myuser;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/13 16:08
 **/
public interface UserService {
    //分页业务
    //参数：前端给我提供什么一般写什么：以为要做分页 只需要返回分页信息
    public PageInfo<Myuser> page(int currentIndex, int pageSize);
}
