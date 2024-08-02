package dao;

import pojo.Email;
import pojo.Page;

import java.util.List;

public interface EmailDao {
    //根据传进来的用户名和是发送方还是接收方，再加上分页类查询指定行数的邮件
    //0是to，1是from
    //value值是条件查询的值，为空就不按搜索条件查询
    List<Email> emaiLimit(int fromOrTo,String username, Page page,String value);

    //根据传进来的用户名和是发送方还是接收方，查询出总共的行数
    int emailCount(int fromOrTo,String username,String value);

    //发送邮箱，即在email表中新增一条数据
    int addEmail(Email email);

    //根据邮件id查邮件
    Email selectEmailById(int id);

    //设置邮件状态为已读
    int updateState(int id);
}
