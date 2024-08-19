package com.springboot.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:后端返回给前端统一的json格式
 * @DateTime:2024/8/19 14:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code;//1成功  0失败
    private String msg;//请求处理后返回给前端的信息
    private Object data;//请求处理之后返回给前端的数据
}
