package day6;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:通过反射创建对象
 * @DateTime:2024/7/1 14:44
 **/
public class Demo2 {
    private Demo2(){
        System.out.println("无参构造");
    }
    public Demo2(Integer n){
        System.out.println("一个参数构造");
    }
    public Demo2(String a,Integer b){
        System.out.println("两个参数构造");
    }
}

class TestDemo2{
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //1.通过Class对象直接创建
        Class<Demo2> c1 = Demo2.class;
        //创建对象 底层原理 无参构造方法，两个缺点：1.只能调用无参 2.不能设置访问私有
//        Demo2 d = c1.newInstance();
//        System.out.println(d);
        //2.通过构造方法对象创建
        Constructor<Demo2> con1 = c1.getDeclaredConstructor();
        Constructor<Demo2> con2 = c1.getDeclaredConstructor(Integer.class);
        Constructor<Demo2> con3 = c1.getDeclaredConstructor(String.class,Integer.class);
        //创建对象 底层原理：所有的构造方法 并且可以设置私有权限
        con1.setAccessible(true);
        Demo2 d1 = con1.newInstance();
        Demo2 d2 = con2.newInstance(100);
        Demo2 d3 = con3.newInstance("java",100);
    }
}

