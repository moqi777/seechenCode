package day2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试sql注入
 * @DateTime:2024/7/19 10:54
 **/
public class TestSqlInjection {
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://127.0.0.1:3306/sc240601?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&rewriteBatchedStatement=true&serverTimezone=Asia/Shanghai";
    private static final String username="root";
    private static final String password="kaipule452b.";
    public static void main(String[] args) throws Exception{
        //传入非法参数
        String name="qsv' or '1'='1";
        //String name="qsv";
        test2(name);
    }
    //测试存在sql注入隐患的方法
    public static void test1(String name)throws Exception{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();
        String sql ="delete from user where name='"+name+"'";
        System.out.println(stmt.executeUpdate(sql));
        stmt.close();
        conn.close();
    }
    //解决sql注入隐患的方法
    public static void test2(String name)throws Exception{
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
//        Statement stmt = conn.createStatement();
//        String sql ="delete from user where name='"+name+"'";
//        System.out.println(stmt.executeUpdate(sql));
        //创建预编译对象 先编译sql 后运行 参数通过?来占位
        String sql ="delete from user where name=?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        //执行语句之前 处理一下问号 给问号赋值
        //pstmt.set类型(整数：第几个问号,数据)
        pstmt.setString(1,name);
        int i = pstmt.executeUpdate();
        System.out.println(i);
        pstmt.close();
        conn.close();
    }
}

