package dao;

import pojo.EmailUser;

import java.util.List;

public interface EmailUserDao {
    //注册
    int register(EmailUser mailUser);

    //根据传入的参数动态查询
    List<EmailUser> selectEmailUser(EmailUser emailUser);
}
