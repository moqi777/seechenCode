package dao.Impl;

import dao.WordsDao;
import pojo.Words;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:敏感词实现类
 * @DateTime:2024/7/31 20:05
 **/
public class WordsDaoImpl implements WordsDao {
    public List<Words> show() {
        String sql = "select * from words";
        ResultSet resultSet = DBUtil.select(sql);
        List<Words> list = new ArrayList<>();
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String word = resultSet.getString("word");
                list.add(new Words(id,word));
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(resultSet,DBUtil.pstmt,DBUtil.conn);
        }
        return null;
    }
}
