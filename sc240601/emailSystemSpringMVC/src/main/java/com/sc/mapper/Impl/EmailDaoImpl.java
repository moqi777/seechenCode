package com.sc.mapper.Impl;

import com.sc.mapper.EmailDao;
import com.sc.pojo.Email;
import com.sc.pojo.Page;
import com.sc.util.DBUtil;

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
    //0，1是from 要按时间的倒序
    public List<Email> emaiLimit(int fromOrTo, String username, Page page, String value) {
        String sql = "select * from email where 1=1";
        ArrayList<Object> parameter = new ArrayList<>();
        //对要找的是发送方还是接收方的邮件进行判断
        if (fromOrTo == 0) {
            sql += " and toname=?";
        } else{
            sql += " and fromname=?";
        }
        parameter.add(username);
        //判断是否有查询条件
        if (value != null){
            sql += " and (fromname like ? or title like ? or content like ?)";
            parameter.add("%"+value+"%");
            parameter.add("%"+value+"%");
            parameter.add("%"+value+"%");
        }
        //再拼接上分页
        sql += " order by createdate desc limit ?,?";
        //拼接上分页相关参数
        parameter.add((page.getCurrentIndex() - 1) * page.getPageSize());
        parameter.add(page.getPageSize());
        ResultSet resultSet = DBUtil.select(sql,parameter.toArray());
        return showResultSet(resultSet);
    }

    public int emailCount(int fromOrTo, String username,String value) {
        String sql = "select count(1) from email where 1=1";
        ArrayList<Object> parameter = new ArrayList<>();
        if (fromOrTo == 0){
            sql += " and toname=?";
        } else{
            sql += " and fromname=?";
        }
        parameter.add(username);
        //判断是否有查询条件
        if (value != null){
            sql += " and (fromname like ? or title like ? or content like ?)";
            parameter.add("%"+value+"%");
            parameter.add("%"+value+"%");
            parameter.add("%"+value+"%");
        }
        ResultSet resultSet = DBUtil.select(sql,parameter.toArray());
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

    public int deleteEmailByIds(int[] ids) {
        String sql = "delete from email where id=?";
        int i=0;
        for (int id : ids) {
            i += DBUtil.update(sql,id);
        }
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }

    public int updateEmailStateByIds(int[] ids) {
        String sql = "update email set state=0 where id=?";
        int i=0;
        for (int id : ids) {
            i += DBUtil.update(sql,id);
        }
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
