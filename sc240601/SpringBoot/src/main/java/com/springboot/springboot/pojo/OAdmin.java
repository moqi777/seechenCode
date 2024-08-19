package com.springboot.springboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OAdmin implements Serializable {
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String status;

    private Date createtime;

    private String sex;

    private Integer roleid;

    private String headPic;

    private Integer operator;

    private static final long serialVersionUID = 1L;
}