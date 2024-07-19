package day1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试executeBatch
 * @DateTime:2024/7/19 10:00
 **/
public class Job2 {
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://127.0.0.1:3306/sc240601?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&rewriteBatchedStatement=true&serverTimezone=Asia/Shanghai";
    private static final String username="root";
    private static final String password="kaipule452b.";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();

        List<String> names = new ArrayList();
        while (names.size() <= 1000) {
            char letter1 = (char) ((int) (Math.random() * 26) + 97);//随机字母
            char letter2 = (char) ((int) (Math.random() * 26) + 97);
            char letter3 = (char) ((int) (Math.random() * 26) + 97);
            //拼接字母
            String name = "" + letter1 + letter2 + letter3;
            if (!names.contains(name)) {
                names.add(name);
            }
        }
        long time = new Date().getTime();
        for (int i = 0; i < 1000; i++) {
            int integral = (int) (Math.random() * 201);//0-200随机数
            Date date = new Date();
            date.setYear(120);
            date.setMonth((int) (Math.random() * 12));
            date.setDate((int) (Math.random() * 28 + 1));
            User user = new User(names.get(i), date, integral, "男");
            stmt.addBatch("INSERT INTO user (name, regTime, integral, sex) VALUES ('"
                    + user.getName() + "', '"
                    + new java.sql.Timestamp(user.getRegTime().getTime()) + "', "
                    + user.getIntegral() + ", '"
                    + user.getSex() + "')");
        }
        stmt.executeBatch();
        long time1 = new Date().getTime();
        System.out.println(time1 - time);
        stmt.close();
        conn.close();
    }
}

