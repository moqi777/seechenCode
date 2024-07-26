package dao.Impl;

import dao.UserDao;
import pojo.User;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        if (user.getPhone()==null || user.getPassword()==null || user.getMoney() == null || user.getServiceId()==null){
            return 0;
        }
        String sql = "insert into doudouUser values(null,?,?,?,?)";
        int i = DBUtil.update(sql,user.getPhone(), user.getPassword(), user.getMoney(), user.getServiceId());
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }

    @Override
    public User login(String phone, String password) {
        if (phone==null || password==null){
            return null;
        }
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

    @Override
    public List<User> show() {
        String sql = "select * from doudouUser";
        ResultSet set = DBUtil.select(sql);
        List<User> list = new ArrayList<>();
        try {
            while (set.next()){
                int id = set.getInt("id");
                String phone1 = set.getString("phone");
                String password1 = set.getString("password");
                double maney = set.getDouble("money");
                int serviceId = set.getInt("serviceId");
                User user = new User(id, phone1, password1, maney, serviceId);
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(set,DBUtil.pstmt,DBUtil.conn);
        }
        return list;
    }

    public int deleteUser(Integer id) {
        String sql = "delete from doudouUser where id=?";
        int i = DBUtil.update(sql, id);
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }

    //根据id修改用户信息
    public int updateUser(User user) {
        String sql = "update doudouUser set phone=?,password=?,money=?,serviceId=? where id=?";
        int i = DBUtil.update(sql, user.getPhone(), user.getPassword(), user.getMoney(), user.getServiceId(), user.getId());
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }
}
