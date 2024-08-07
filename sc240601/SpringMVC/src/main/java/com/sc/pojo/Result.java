package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:前后端分离 所有请求返回结果
 * 结果code 信息msg 数据Object data
 * @DateTime:2024/8/7 12:13
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;//表示结果状态 1成功 0失败
    private String msg;//表示返回给前端 信息
    private Object data;//表示返回给前端的数据
}
