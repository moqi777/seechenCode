package dao.Impl;

import dao.UserDao;
import pojo.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/24 19:27
 **/
public class UserDaoImpl implements UserDao {
    @Override
    public int reg(User user) {
        String sql = "insert into doudouUser values(null,?,?,?,?)";
        int i = DBUtil.update(sql,user.getPhone(), user.getPassword(), user.getMoney(), user.getServiceId());
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }

    @Override
    public User login(String phone, String password) {
        String sql = "select * from doudouUser where phone = ? and password = ?";
        ResultSet set = DBUtil.select(sql, phone, password);
        try {
            if (set.next()){
                int id = set.getInt("id");
                String phone1 = set.getString("phone");
                String password1 = set.getString("password");
                double maney = set.getDouble("money");
                int serviceId = set.getInt("serviceId");
                return new User(id,phone1,password1,maney,serviceId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(set,DBUtil.pstmt,DBUtil.conn);
        }
        return null;
    }
}
