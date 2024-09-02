package com.sc.kuaizilive.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class KUser implements Serializable {
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

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getAreacode() {
        return areacode;
    }

    public void setAreacode(String areacode) {
        this.areacode = areacode == null ? null : areacode.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPaymentcode() {
        return paymentcode;
    }

    public void setPaymentcode(String paymentcode) {
        this.paymentcode = paymentcode == null ? null : paymentcode.trim();
    }

    public String getUserPetname() {
        return userPetname;
    }

    public void setUserPetname(String userPetname) {
        this.userPetname = userPetname == null ? null : userPetname.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", userPhone=").append(userPhone);
        sb.append(", areacode=").append(areacode);
        sb.append(", password=").append(password);
        sb.append(", paymentcode=").append(paymentcode);
        sb.append(", userPetname=").append(userPetname);
        sb.append(", userSex=").append(userSex);
        sb.append(", userEmail=").append(userEmail);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}