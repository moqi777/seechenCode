package dao.Impl;

import dao.EmailUserDao;
import pojo.EmailUser;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:MailUserDao实现类
 * @DateTime:2024/7/29 20:47
 **/
public class EmailUserDaoImpl implements EmailUserDao {
    public int register(EmailUser mailUser) {
        String sql = "insert into email_user values(?,?,?,?)";
        int i = DBUtil.update(sql, null, mailUser.getUsername(), mailUser.getPassword(), mailUser.getEmail());
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }

    @Override
    public List<EmailUser> selectEmailUser(EmailUser emailUser) {
        List<Object> parameter = new ArrayList<>();
        String sql = "select * from email_user where 1=1";
        //根据是否有传入的值动态拼接sql语句
        if (emailUser.getId() != null){
            sql += " and id=?";
            parameter.add(emailUser.getId());
        }
        if (emailUser.getUsername() != null){
            sql += " and username=?";
            parameter.add(emailUser.getUsername());
        }
        if (emailUser.getEmail() != null){
            sql += " and email=?";
            parameter.add(emailUser.getEmail());
        }
        ResultSet resultSet = DBUtil.select(sql, parameter.toArray());
        return showResultSet(resultSet);
    }

    //本类专门的工具类，用于将resultSet中的数据读取出来封装成List
    private List<EmailUser> showResultSet(ResultSet resultSet){
        List<EmailUser> emailUsers = new ArrayList<>();
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                String email = resultSet.getString("email");
                emailUsers.add(new EmailUser(id,username,password,email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //获取完后关流
        DBUtil.close(resultSet,DBUtil.pstmt,DBUtil.conn);
        return emailUsers;
    }
}
