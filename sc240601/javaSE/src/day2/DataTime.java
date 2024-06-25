package day2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:关于日期的一些实现
 * @DateTime:2024/6/25 10:47
 **/

/*
关于时间的类型有三种
1.Date (java.util.Date(绝大部分使用)  java.sql.Date(访问数据库特定类型))
2.Calender   日历对象
3.LocalTime LocalDate LocalDateTime  1.8日期类型
 */
public class DataTime {
    public static void main(String[] args) throws ParseException {
        date3();
    }
    //date类型的实现
    public static void date1() throws ParseException {
        //1.创建当前系统时间（默认格式）Tue Jun 25 10:32:23 CST 2024
        Date date = new Date();
        System.out.println(date);
        //2.对日期进行格式化处理
        //日期格式: y年 M月 d日 h12进制 H24进制  m分  s秒 S毫秒 a上午/下午
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss S a");

        //Date=>String
        String format = sdf.format(date);
        System.out.println(format);
        //String=>Date String的格式必须和构造函数中的参数一致，否则抛异常
        Date dd = sdf.parse("2024-06-25 10:54:18 289 上午");
        System.out.println(dd);

        //java.util.Date => java.sql.Date
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
        //java.sql.Date => java.util.Date
        Date ddd = new Date(sqlDate.getTime());
        System.out.println(ddd);
    }
    //Colender日历对象
    public static void date2(){
        //优点：提供很多封装好的常量 获取日期制定内容
        //缺点：不是日期类型 需要封装Date类型才能使用
        //1.创建日历对象
        Calendar cal = Calendar.getInstance();
        //2.设置时间
        Date d = new Date();
        cal.setTime(d);
        cal.set(2012,10,20);
        //3.日历会针对这个日期 计算好很多常量
        //cal.get(Calendar.常量)
        cal.get(Calendar.DAY_OF_MONTH);
        //4.日历做一些简单运算
        //cal.add(Calendar.常量,数值);
        cal.add(Calendar.MONTH,10);
    }
    //jdk1.8开始支持新日期格式
    public static void date3(){
        //instant：代表时间戳（时间完整格式）
        //LocalDate：代表年-月-日
        //LocalTime：代表时:分;秒
        //LocalDateTime：代表年-月-日 时:分:秒
        //now() 静态方法 表示当前时间
        //of() 静态方法 手动传入年月日 时分秒
        Instant in = Instant.now();
        System.out.println("时间戳："+in);
        LocalDate ld = LocalDate.now();
        System.out.println("日期："+ld);
        LocalDate of = LocalDate.of(2014, 5, 15);
        System.out.println(of);

        //2.jdk1.8日期类型提供很多方法 获取日期指定部分
        DayOfWeek dw = ld.getDayOfWeek();
        System.out.println("星期"+dw);

        //3.提供修改的方法
        //日期.withXXX()
        ld = ld.with(DayOfWeek.WEDNESDAY);
        System.out.println("修改成星期三："+ld);

        //4.对日期做加减法
        //日期.plusXXX() 做加法 只需要会一个(+ 正数和负数)
        //日期.minusXXX() 做减法
        ld = ld.plusWeeks(1);
        System.out.println("加完一周："+ld);
        ld = ld.plusMonths(-1);
        System.out.println("减一个月："+ld);
        //ld.isLeapYear(); 计算闰年
        //日期.until(日期).getDays .getYears：获取两个日期时间差
        LocalDate ld1 = LocalDate.of(2000, 11, 27);
        int days = ld1.until(ld).getYears();
        System.out.println("时间差："+days);
    }
}

