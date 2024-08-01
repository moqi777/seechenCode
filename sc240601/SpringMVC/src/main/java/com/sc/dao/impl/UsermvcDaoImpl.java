package com.sc.dao.impl;

import com.sc.dao.UsermvcDao;
import com.sc.pojo.Usermvc;
import com.sc.util.DBUtil;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/1 17:05
 **/
public class UsermvcDaoImpl implements UsermvcDao {
    public int add(Usermvc u) {
        String sql = "insert into usermvc values(null,?,?,?,?)";
        int i = DBUtil.update(sql, u.getName(), u.getMoney(), u.getTime(), u.getHead());
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }

    public List<Usermvc> show() {
        String sql = "select * from usermvc";
        ResultSet resultSet = DBUtil.select(sql);
        List<Usermvc> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                list.add(getOject(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet,DBUtil.pstmt,DBUtil.conn);
        }
        return list;
    }

    public Usermvc getOject(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        double money = resultSet.getDouble("money");
        Date time = resultSet.getDate("time");
        String head = resultSet.getString("head");
        return new Usermvc(id,name,money,time,head);
    }
}
