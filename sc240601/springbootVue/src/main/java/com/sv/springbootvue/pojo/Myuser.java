package com.sv.springbootvue.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Myuser implements Serializable {
    //添加两个测试属性，搜索需要，不是表的数据
    private Date regtime1;
    private Date regtime2;

    private Integer id;

    private String name;

    //后端返回json格式 需要添加这个注解
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date regtime;

    private Integer integral;

    private String sex;

    private static final long serialVersionUID = 1L;
}