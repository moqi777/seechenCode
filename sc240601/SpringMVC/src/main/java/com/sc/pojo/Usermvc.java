package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usermvc {
    //提供了有参构造必须提供无参 很多框架都需要用到无参
    private Integer id;
    private String name;
    private double money;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date time;
    private  String head;
}
