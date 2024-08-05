package com.sc.dao.impl;

import com.sc.dao.UuserDao;
import com.sc.pojo.Uuser;
import com.sc.util.DBUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/5 20:46
 **/
public class UuserDaoimpl implements UuserDao {
    public Uuser selectToAccount(String account) {
        String sql = "select * from uuser where account=?";
        ResultSet resultSet = DBUtil.select(sql, account);
        Uuser uuser = null;
        try {
            if (resultSet.next()){
                 uuser = show(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        DBUtil.close(resultSet,DBUtil.pstmt,DBUtil.conn);
        return uuser;
    }

    public Uuser show(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        String account = resultSet.getString("account");
        String password = resultSet.getString("password");
        String dept = resultSet.getString("dept");
        String headImg = resultSet.getString("headImg");
        int genderInt = resultSet.getInt("gender");
        String email = resultSet.getString("email");
        String mobile = resultSet.getString("mobile");
        String memo = resultSet.getString("memo");
        Date birthday = resultSet.getDate("birthday");
        int state = resultSet.getInt("state");
        return new Uuser(id+"",name,account,password,dept,headImg,genderInt==1,email,mobile,memo,birthday,state==0?"无效":"有效");
    }
}
