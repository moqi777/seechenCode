package com.sc.kuaizilive.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class KEconomics implements Serializable {
    private Integer id;

    private String userName;

    private String nickname;

    private String gender;

    private String region;

    private String address;

    private String phone;

    private String wechat;

    private String telegram;

    private Float area;

    private String rooms;

    private String floor;

    private Date createdAt;

    private Date updatedAt;

    private String message;

    private static final long serialVersionUID = 1L;
}