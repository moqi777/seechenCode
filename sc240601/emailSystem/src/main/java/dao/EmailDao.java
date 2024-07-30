package dao;

import pojo.Email;
import pojo.Page;

import java.util.List;

public interface EmailDao {
    //根据传进来的用户名和是发送方还是接收方，再加上分页类查询指定行数的邮件
    //0是to，1是from
    List<Email> emaiLimit(int formOrTo,String username, Page page);

    //根据传进来的用户名和是发送方还是接收方，查询出总共的行数
    int emailCount(int formOrTo,String username);
}
