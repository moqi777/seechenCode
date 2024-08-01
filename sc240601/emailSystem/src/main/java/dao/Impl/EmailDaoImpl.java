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
import java.util.Date;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/30 22:33
 **/
public class EmailDaoImpl implements EmailDao {
    //0是to，1是from 要按时间的倒序
    public List<Email> emaiLimit(int fromOrTo, String username, Page page) {
        String sql = "select * from email where 1=1";
        if (fromOrTo == 0) sql += " and toname=?";
        else sql += " and fromname=?";
        //再拼接上分页
        sql += " order by createdate desc limit ?,?";
        ResultSet resultSet = DBUtil.select(sql, username, (page.getCurrentIndex() - 1) * page.getPageSize(), page.getPageSize());
        return showResultSet(resultSet);
    }

    public int emailCount(int fromOrTo, String username) {
        String sql = "select count(1) from email where 1=1";
        if (fromOrTo == 0) sql += " and toname=?";
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

    public int addEmail(Email email) {
        String sql = "insert into email values(?,?,?,?,?,?,?)";
        Timestamp timestamp = new Timestamp(new Date().getTime());
        int i = DBUtil.update(sql, null, email.getFromname(), email.getTitle(),
                email.getContent(), 1, email.getToname(), timestamp);
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }

    public Email selectEmailById(int id) {
        String sql = "select * from email where id=?";
        ResultSet resultSet = DBUtil.select(sql,id);
        List<Email> emails = showResultSet(resultSet);
        return emails.get(0);
    }

    public int updateState(int id) {
        String sql = "update email set state=0 where id=?";
        int i = DBUtil.update(sql,id);
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
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
