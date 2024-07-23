package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/22 11:23
 **/
//jdbc工具类：将jdb所有共同的操作统一处理，防止代码冗余
//工具类方法都是静态的 都是为了通过类名.方法 方便使用的
//比如：Arrays.sort()
//jdbc：哪些是可以统一处理的
//1.加载驱动类 只做一次 最先做
//2.创建连接 要做多次 由于代码都一样
//3.url driver username password    如果切换数据库
//可能会修改 可以把他们单独提出来 当成一个文件 这样就不用去修改类
//这样程序只要读取这个文件(配置文件properties yml xml) 就可以得到这些配置
//4.关闭资源 因为都需要关闭
//5.增  删  改  可以编写一种通用写法
//6.查询 也可以写一个半通用写法 rs返回
public class DBUtil2 {  //扩展
    //不推荐直接复制 在properties配置文件编写 读取赋值即可
    private static String driver;
    private static String url;
    private static String username;
    private static String password;
    static {
        //配置文件不是java文件 不会随着项目启动 main运行自动加载
        //一般都必须 先读取配置文件 才能获取里面的内容
        // 路径：直接根目录(蓝色的包)开始找
        InputStream is = DBUtil2.class.getClassLoader().getResourceAsStream("config/jdbc.properties");
        //创建properties对象
        Properties p = new Properties();
        try {
            //通过InputStream对象 将数据封装到properties中
            p.load(is);
            driver = p.getProperty("driver");
            url = p.getProperty("url");
            username = p.getProperty("username");
            password = p.getProperty("password");
            //直接加载驱动类
            Class.forName(driver);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //定义一个本地线程 只存储连接对象 它和其他线程独享
    static ThreadLocal<Connection> tl=new ThreadLocal<>();
    //创建连接通用方法
    // 一个用户一个线程 只有一个连接 除非连接被回收了
    public static Connection getConn(){
        Connection conn = tl.get();
        try {
            //第一次使用 获取新连接 存储到本地线程
            if (conn==null){
                conn = DriverManager.getConnection(url,username,password);
                tl.set(conn);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    //关闭连接通用方法，通过传参的顺序 来控制关闭的顺序
    //关闭的时候 本地线程也要清空
    public static void close(AutoCloseable... able){
        tl.remove();    //清空
        for (AutoCloseable a : able) {
            if (a!=null) {
                try {
                    a.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //增删改通用方法
    //bug：sql语句占位符个数 一定要和后面参数o数组长度一致 顺序也得一致
    public static int update(String sql, Object ... o){
        conn = getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            if (o!=null){//是否有参数
                for (int i = 0; i < o.length; i++) {
                    pstmt.setObject(i+1,o[i]);
                }
            }
            int i = pstmt.executeUpdate();
            System.out.println("受影响的行数："+i);
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    //查询通用方法
    //存在两个问题：
    // 1：返回的是ResultSet 需要用户自己封装数据
    // 2：查询的方法不能关闭资源 因为用户还需要处理结果集 处理完之后才可以关闭
    public static Connection conn;
    public static PreparedStatement pstmt;
    public static ResultSet select(String sql, Object... o){
        conn = getConn();
        try {
            pstmt = conn.prepareStatement(sql);
            if (o!=null){//是否有参数
                for (int i = 0; i < o.length; i++) {
                    pstmt.setObject(i+1,o[i]);
                }
            }
            return pstmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

