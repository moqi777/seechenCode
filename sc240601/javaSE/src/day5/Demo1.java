package day5;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Date;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试反射：测试Person类
 * @DateTime:2024/6/28 12:00
 **/
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        //1.获取类
        Class c1=Person.class;
        Class c2=Class.forName("day5.Person");
        Person c3 = new Person("张三", 18);
        c3.getClass();
        //2.通过类对象动态获取类中的所有资源
        String name = c1.getName();
        System.out.println("全类名："+name);
        String simpleName = c1.getSimpleName();
        System.out.println("类名："+simpleName);
        String superName = c1.getSuperclass().getName();
        System.out.println("父类全类名："+superName);
        System.out.println("=================获取属性Field=================");
        //获取该类中不包括父类的属性
        Field[] dfs = c1.getDeclaredFields();
        //获取该类中所有公开属性（父类的...）
        Field[] fs = c1.getFields();
        System.out.println(Arrays.toString(dfs));
        System.out.println(Arrays.toString(fs));
        //获取一个属性（如果是私有的情况）
        Field f1 = c1.getDeclaredField("name");//私有的
        Field f2 = c1.getDeclaredField("time");//共有的
        //设置属性值 获取属性值
        f2.set(c3,new Date());//等价于p,time=new Date();
        Object value = f2.get(c3);//等价于p,time
        System.out.println("日期属性："+value);
        //如果是私有属性 如何处理
        f1.setAccessible(true);//开启私有访问
        f1.set(c3,"李白");
        Object value2 = f1.get(c3);
        System.out.println("姓名属性："+value2);
    }
}

