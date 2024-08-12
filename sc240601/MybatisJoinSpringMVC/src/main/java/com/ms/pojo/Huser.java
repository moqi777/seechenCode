package com.ms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Huser implements Serializable {
    private Hdept dept;

    private Huserinfo info;

    private Integer id;

    private String username;

    private String password;

    private Date createtime;

    private Integer did;

    private static final long serialVersionUID = 1L;
}