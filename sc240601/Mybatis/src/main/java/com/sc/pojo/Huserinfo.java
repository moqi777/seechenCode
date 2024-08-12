package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
public class Huserinfo implements Serializable {
    private Integer id;

    private String sex;

    private Integer age;

    private String mess;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess == null ? null : mess.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", mess=").append(mess);
        sb.append("]");
        return sb.toString();
    }
}