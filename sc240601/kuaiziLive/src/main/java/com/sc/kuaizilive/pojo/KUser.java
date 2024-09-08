package com.sc.kuaizilive.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KUser implements Serializable {
    private String token;

    private Integer userId;

    private String userName;

    private String userPhone;

    private String areacode;

    private String password;

    private String paymentcode;

    private String userPetname;

    private String userSex;

    private String userEmail;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    private Integer type;

    private String head;

    private static final long serialVersionUID = 1L;
}