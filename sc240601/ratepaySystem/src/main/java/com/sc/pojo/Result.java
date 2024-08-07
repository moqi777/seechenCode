package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:异步消息实体类
 * @DateTime:2024/8/7 20:31
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private int code;//1成功 0失败
    private String msg;
    private Object data;
}
