package day6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:通过反射调用方法
 * @DateTime:2024/7/1 14:16
 **/
public class Demo1 {
    public void test1(){
        System.out.println("测试1");
    }
    private int test2(Integer num){
        System.out.println("测试2");
        return 100;
    }
    public void test3(String a,Integer b){
        System.out.println("测试3");
    }
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = Class.forName("day6.Demo1");
        //获取本类所有的方法(没有父类)
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            String name = method.getName();
            Class<?>[] cs = method.getParameterTypes();
            Class<?> result = method.getReturnType();
            System.out.println(name+" "+ Arrays.toString(cs) +" "+result);
        }
        //获取一个方法对象 进行调用（参数1：方法名,参数2：方法的参数的Class类型）
        Method test1 = c.getDeclaredMethod("test1");
        Method test2 = c.getDeclaredMethod("test2", Integer.class);
        Method test3 = c.getDeclaredMethod("test3", String.class, Integer.class);
        //调用方法（参数1：对象,参数2：实参） 返回值：方法调用的结果
        Demo1 d = new Demo1();
        Object resullt1 = test1.invoke(d);
        test2.setAccessible(true);
        Object resullt2 = test2.invoke(d,100);
        Object resullt3 = test3.invoke(d,"java",1000);
        System.out.println(resullt1);
        System.out.println(resullt2);
        System.out.println(resullt3);
    }
}

