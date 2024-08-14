package com.spring.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 10:54
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Integer id;
    private String name;
    private double moeny;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;

    public User(Integer id, String name, double moeny) {
        this.id = id;
        this.name = name;
        this.moeny = moeny;
    }
}
