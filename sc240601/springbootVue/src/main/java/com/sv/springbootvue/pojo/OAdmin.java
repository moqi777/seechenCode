package com.sv.springbootvue.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OAdmin implements Serializable {
    private String token;
    private Integer id;

    private String account;

    private String password;

    private String name;

    private String phone;

    private String email;

    private String status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createtime;

    private String sex;

    private Integer roleid;

    private String headPic;

    private Integer operator;

    private static final long serialVersionUID = 1L;
}