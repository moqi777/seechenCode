package day6;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:通过反射实现通用方法的调用
 * @DateTime:2024/7/1 15:01
 **/
public class Demo3 {
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
    public void test4(int a){
        System.out.println("测试4");
    }
}

class TestDemo3{
    //通用方法 反射可以调用任意对象的任意方法
    //返回值：目标方法的返回值
    //参数1：调用方法的对象 参数2：方法名 参数3：方法的实参
    //bug：如果传递了基本类型，会自动转换成封装类型 导致了方法不存在
    public static Object base(Object o,String name,Object... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = o.getClass();
        Class[] args = new Class[params.length];
        for (int i = 0; i < params.length; i++) {
            args[i] = params[i].getClass();
        }
        Method method = c.getDeclaredMethod(name, args);
        method.setAccessible(true);
        return method.invoke(o,params);
    }
    //bug：方法重载
    public static Object base2(Object o,String name,Object... params) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class c = o.getClass();
        Class[] args = new Class[params.length];
        Method[] ms = c.getDeclaredMethods();
        for (Method m : ms) {
            if (m.getName().equals(name)) {
                args = m.getParameterTypes();
                break;
            }
        }
        Method method = c.getDeclaredMethod(name, args);
        method.setAccessible(true);
        return method.invoke(o,params);
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Demo3 d = new Demo3();
        base2(d,"test1");
        base2(d,"test2",100);
        base2(d,"test3","java",100);
        base2(d,"test4",100);
    }
}

