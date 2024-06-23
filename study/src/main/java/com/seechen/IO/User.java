package com.seechen.IO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:序列化登录注册持久化demo
 * @DateTime:2024/6/23 16:30
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    //标识类的版本，在序列化和反序列化时会核对
    private static final long serialVersionUID = -666L;
    private String username;//账号
    private String password;//密码
    private String nickname;//昵称
}

