package dao.Impl;

import dao.MailUserDao;
import pojo.MailUser;
import util.DBUtil;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:MailUserDao实现类
 * @DateTime:2024/7/29 20:47
 **/
public class MailUserDaoImpl implements MailUserDao {
    public int register(MailUser mailUser) {
        String sql = "insert into mail_user values(?,?,?,?)";
        int i = DBUtil.update(sql, null, mailUser.getUsername(), mailUser.getPassword(), mailUser.getEmail());
        DBUtil.close(DBUtil.pstmt,DBUtil.conn);
        return i;
    }
}
