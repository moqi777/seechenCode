package com.sc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
//切记：关联映射 根据需求来 不要做双向关联
public class Huser implements Serializable {
    //1:1关联属性
    private Huserinfo info;

    private Integer id;

    private String username;

    private String password;

    private Date createtime;

    private Integer did;

    private static final long serialVersionUID = 1L;

    public Huser(Integer id, String username, String password, Date createtime, Integer did) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.createtime = createtime;
        this.did = did;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Integer getDid() {
        return did;
    }

    public void setDid(Integer did) {
        this.did = did;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", createtime=").append(createtime);
        sb.append(", did=").append(did);
        sb.append("]");
        return sb.toString();
    }
}