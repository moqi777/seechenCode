package day1;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:作业
 * @DateTime:2024/7/18 18:52
 **/
//自定义一张用户表  用户id  昵称 注册时间  积分  性别
//通过jdbc 模拟模拟用户表的数据
//编写四个方法 分别实现增  删 改 查
public class Job1 {
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://127.0.0.1:3306/sc240601?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&rewriteBatchedStatement=true&serverTimezone=Asia/Shanghai";
    private static final String username="root";
    private static final String password="kaipule452b.";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();

        List<String> names = new ArrayList();
        while (names.size()<=100){
            char letter1 = (char)((int)(Math.random()*26)+97);//随机字母
            char letter2 = (char)((int)(Math.random()*26)+97);
            char letter3 = (char)((int)(Math.random()*26)+97);
            //拼接字母
            String name = ""+letter1+letter2+letter3;
            if (!names.contains(name)){
                names.add(name);
            }
        }
        for (int i = 0; i < 100; i++) {
            int integral = (int)(Math.random()*201);//0-200随机数
            Date date = new Date();
            date.setYear(120);
            date.setMonth((int)(Math.random()*12));
            date.setDate((int)(Math.random()*28+1));
            User u = new User(names.get(i), date, integral, "男");
            add(u,stmt);
        }
        stmt.close();
        conn.close();
        //select();
    }
    public static void select(Statement stmt) throws ClassNotFoundException, SQLException {
        String sql = "select * from user";
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String regTime = resultSet.getString(3);
            String integral = resultSet.getString(4);
            String sex = resultSet.getString(5);
            System.out.println(id+" "+name+" "+regTime+" "+integral+" "+sex);
        }
        resultSet.close();
//        stmt.close();
//        conn.close();
    }
    public static void add(User user,Statement stmt) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO user (name, regTime, integral, sex) VALUES ('"
                + user.getName() + "', '"
                + new java.sql.Timestamp(user.getRegTime().getTime()) + "', "
                + user.getIntegral() + ", '"
                + user.getSex() + "')";
        int i = stmt.executeUpdate(sql);
        System.out.println("受影响的行数："+i);
        //stmt.close();
        //conn.close();
    }
    public static void del(int id,Statement stmt) throws ClassNotFoundException, SQLException {
        String sql = "delete from user where id="+id;
        int i = stmt.executeUpdate(sql);
        System.out.println("受影响的行数："+i);
//        stmt.close();
//        conn.close();
    }
    public static void update(User user,Statement stmt) throws ClassNotFoundException, SQLException {
        String sql = "update user set integral="+user.getIntegral()+" where name='"+user.getName()+"'";
        int i = stmt.executeUpdate(sql);
        System.out.println("受影响的行数："+i);
//        stmt.close();
//        conn.close();
    }
}

class User{
    private Integer id;
    private String name;
    private Date regTime;
    private Integer integral;
    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public User(String name, Date regTime, Integer integral, String sex) {
        this.name = name;
        this.regTime = regTime;
        this.integral = integral;
        this.sex = sex;
    }

    public User() {
    }

    public User(Integer id, String name, Date regTime, Integer integral, String sex) {
        this.id = id;
        this.name = name;
        this.regTime = regTime;
        this.integral = integral;
        this.sex = sex;
    }
}

