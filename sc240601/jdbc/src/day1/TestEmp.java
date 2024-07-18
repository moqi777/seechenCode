package day1;

import java.sql.*;
import java.util.Date;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试 增删改
 * @DateTime:2024/7/18 16:43
 **/
public class TestEmp {
    private static final String driver="com.mysql.cj.jdbc.Driver";
    private static final String url="jdbc:mysql://127.0.0.1:3306/sc240601?useUnicode=true&characterEncoding=utf-8&autoReconnect=true&rewriteBatchedStatement=true&serverTimezone=Asia/Shanghai";
    private static final String username="root";
    private static final String password="kaipule452b.";
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Emp e = new Emp("Tom","撸猫",1,new java.util.Date(),100);
        //add(e);
        Emp e2 = new Emp(1, "cat", null, null, null, 0, 0, null);
        update(e2);
    }
    public static void add(Emp emp) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        //缺点1：日期类型需要处理一下 方式1：直接字符串 方式 2：util.Date==>sql.Date
        //缺点2：传递字符串参数 需要两端拼接单引号
        //缺点3：sql注入的问题
        //缺点4：拼接多个参数的时候 特别繁琐
        //后续：PreparedStatement 预编译对象
        String sql = "INSERT INTO emp (ename, job, mgr, hiredate, sal) VALUES ('"
                + emp.getEname() + "', '"
                + emp.getJob() + "', "
                + emp.getMgr() + ", '"
                + new java.sql.Date(emp.getHiredate().getTime()) + "', "
                + emp.getSal() + ")";
        int i = stmt.executeUpdate(sql);
        System.out.println("受影响的行数："+i);
        stmt.close();
        conn.close();
    }
    public static void update(Emp emp) throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        String sql="";
        int i = stmt.executeUpdate(sql);
        System.out.println("受影响的行数："+i);
        stmt.close();
        conn.close();
    }
    public static void del() throws ClassNotFoundException, SQLException {
        Class.forName(driver);
        Connection conn = DriverManager.getConnection(url,username,password);
        Statement stmt = conn.createStatement();
        String sql="";
        int i = stmt.executeUpdate(sql);
        System.out.println("受影响的行数："+i);
        stmt.close();
        conn.close();
    }
}
//实体类
class Emp{
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private java.util.Date hiredate;
    private double sal;
    private double comm;
    private Integer deptno;

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getMgr() {
        return mgr;
    }

    public void setMgr(Integer mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public double getSal() {
        return sal;
    }

    public void setSal(double sal) {
        this.sal = sal;
    }

    public double getComm() {
        return comm;
    }

    public void setComm(double comm) {
        this.comm = comm;
    }

    public Integer getDeptno() {
        return deptno;
    }

    public void setDeptno(Integer deptno) {
        this.deptno = deptno;
    }

    public Emp() {
    }

    public Emp(String ename, String job, Integer mgr, Date hiredate, double sal) {
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
    }

    public Emp(Integer empno, String ename, String job, Integer mgr, Date hiredate, double sal, double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }
}