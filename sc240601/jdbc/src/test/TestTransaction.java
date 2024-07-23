package test;

import lombok.SneakyThrows;
import util.DBUtil;
import util.DBUtil2;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试jdbc事务
 * @DateTime:2024/7/22 17:06
 **/
public class TestTransaction {
    @SneakyThrows
    public static void main(String[] args) {
        //通过事务如何实现多个操作同时成功和失败
        Connection conn = DBUtil2.getConn();
        conn.setAutoCommit(false);//手动提交
        try {
            DBUtil2.update("insert into dept values(?,?,?)",204,"张三","江西");
            int i=10/0;
            DBUtil2.update("insert into dept values(?,?,?)",104,"李四","武汉");
            conn.commit();
        } catch (SQLException e) {
            conn.rollback();
        }
    }
}

