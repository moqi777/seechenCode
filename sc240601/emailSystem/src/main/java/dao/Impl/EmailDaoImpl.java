package dao.Impl;

import dao.EmailDao;
import pojo.Email;
import pojo.EmailUser;
import pojo.Page;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/30 22:33
 **/
public class EmailDaoImpl implements EmailDao {
    //0是to，1是from
    public List<Email> emaiLimit(int formOrTo, String username, Page page) {
        String sql = "select * from email where 1=1";
        if (formOrTo == 0) sql += " and toname=?";
        else sql += " and fromname=?";
        //再拼接上分页
        sql += " limit ?,?";
        ResultSet resultSet = DBUtil.select(sql, username, (page.getCurrentIndex() - 1) * page.getPageSize(), page.getPageSize());
        return showResultSet(resultSet);
    }

    public int emailCount(int formOrTo, String username) {
        String sql = "select count(1) from email where 1=1";
        if (formOrTo == 0) sql += " and toname=?";
        else sql += " and fromname=?";
        ResultSet resultSet = DBUtil.select(sql,username);
        try {
            if (resultSet.next()){
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet,DBUtil.pstmt,DBUtil.conn);
        }
        return 0;
    }

    //本类专门的工具类，用于将resultSet中的数据读取出来封装成List
    private List<Email> showResultSet(ResultSet resultSet){
        List<Email> emailUsers = new ArrayList<>();
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String fromname = resultSet.getString("fromname");
                String title = resultSet.getString("title");
                String content = resultSet.getString("content");
                int state = resultSet.getInt("state");
                String toname = resultSet.getString("toname");
                Timestamp createdate = resultSet.getTimestamp("createdate");
                emailUsers.add(new Email(id,fromname,title,content,state,toname,createdate));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //获取完后关流
        DBUtil.close(resultSet,DBUtil.pstmt,DBUtil.conn);
        return emailUsers;
    }
}
