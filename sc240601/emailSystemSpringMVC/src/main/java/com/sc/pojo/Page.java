package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:分页使用的实体类
 * @DateTime:2024/7/30 22:27
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    //总页数
    private int totalPages;
    //所有的条数
    private int totalCount;
    //当前的页码
    private int currentIndex;
    //页面容量
    private int pageSize;
}
