package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/7 16:20
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer sno;
    private String sname;
    private String ssex;
    private Date sbirthday;
    private String classname;
}
