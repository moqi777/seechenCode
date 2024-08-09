package com.sc.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/9 15:31
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageUtil<T> {
    private int currentIndex;//当前页码--前端提供
    private int pageSize;//每页条数--后端和前端都可以提供
    private int totalCount;//总条数--数据库查询
    private int totalPage;//总页数--根据总条数和每页条数相除向上取舍得到的
    private List<T> list;//每页的集合数据--数据库查询

    //实现调用 设置总条数的同时 计算并赋值总页数。需要先设置每页条数再设置总条数
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        //根据总条数 和每页条数 相除 向上取舍得到的
        totalPage = (int)Math.ceil(totalCount*1.0/pageSize);
    }
}
