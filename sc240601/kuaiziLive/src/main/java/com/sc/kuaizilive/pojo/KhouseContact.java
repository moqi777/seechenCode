package com.sc.kuaizilive.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KhouseContact implements Serializable {
    private Integer id;

    private Integer posterType;

    private Integer language;

    private String phone;

    private String wechat;

    private String telegram;

    private static final long serialVersionUID = 1L;
}