package day1;

import java.sql.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试的第一个jdbc
 * @DateTime:2024/7/18 14:39
 **/
public class FirstJDBC {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.加载驱动类（前提导入驱动包）
        //mysql 5X：com.mysql.jdbc.Driver
        //mysql 8X：com.mysql.cj.jdbc.Driver
        //oracle：oracle.jdbc.driver.OracleDriver
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.DriverManager驱动管理类 创建数据库连接
        /**
            请求地址：统一资源定位符 俗称网址
            协议://ip地址:端口号/项目资源(数据库名)?可选参数
            可选参数：可以让操作数据库时 数据不会出现不一致(比如乱码和时区)
            写法类似于map集合的每一组参数都是基于key=value&key2=value2&...
            常用可选参数：不用背 以后使用直接CV
            1.useUnicode：表示unicode编码来进行存储
            2.characterEncoding：修改字符集编码（让中文不乱吗）
            3.autoReconnect：是否自动连接
            4.rewriteBatchedStatement：是否开启批处理
            5.serverTimezone：设置时区 mysql8版本一般需要设置 是看数据库和系统时间是否有差异
            6.useSSL：是否使用SSL协议    一般mysql 5.7需要配置这个
         **/
        String url = "jdbc:mysql://127.0.0.1:3306/sc240601?" +
                "useUnicode=true&" +
                "characterEncoding=utf-8&" +
                "autoReconnect=true&" +
                "rewriteBatchedStatement=true&" +
                "serverTimezone=Asia/Shanghai";
        String username = "root";
        String password = "kaipule452b.";
        Connection conn = DriverManager.getConnection(url,username,password);
        //3.通过连接对象创建Statement对象
        Statement stmt = conn.createStatement();
        //4.通过Statement执行sql语句
        /*
        可以用于增删改查四种语句，但是返回值是一个boolean类型
        无法查看 查询的数据  不推荐这种方式
        stmt.execute(sql语句);
        适用于 增删改 三种语句，返回值是int（受影响的行数） 推荐使用
        stmt.executeUpdate(sql语句);
        适用于查询语句 返回值是ResultSet   推荐使用
        stmt.executeQuery(sql语句);
        适用于执行批量操作的时候 比如批量新增100条数据
        stmt.executeBatch();//前面需要结合addBatch(sql)
         */
        String sql="select * from dept";
        //如果sql语句里面 有参数 还需要传递参数
        ResultSet set = stmt.executeQuery(sql);
        //5.只有查询才需要处理结果集（目的是为了取出查询的数据）
        /*
        类似于迭代器 hasNext()判断是否有 next()获取
         .next()等价于迭代器hasNext()
         含义表示每次获取一行数据 然后删除该行 初值指向第0行
         */
        while (set.next()){
            //进入循环表示 获取出了一行数据 下面就需要把这行数据每个字段的值获取出来
            // .get类型(数值) 根据你查询出来的第几个字段 不推荐使用不适合复杂查询
            // .get类型(字符串) 根据你表中字段名称 获取每个字段的值
            int id = set.getInt(1);
            String dname = set.getString("dname");
            String loc = set.getString("loc");
            //后续。。。 看需求 打印或者封装对象 集合
            System.out.println(id+" "+dname+" "+loc);
            //java先需要定义一个类表示部门 类中需要有跟数据库字段一样的属性
            //这种类 以后java称之为 实体类：用于描述表中数据的
            //Dept d=new Depy(deptno,dname,loc);
            //list.add(d);
        }
        //6.释放资源(创建的对象都需要释放)
        //释放资源要注意顺序 遵循栈的原则 先创建后关闭
        set.close();
        stmt.close();
        conn.close();
    }
}

