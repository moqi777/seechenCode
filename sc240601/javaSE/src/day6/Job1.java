package day6;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/1 18:57
 **/
//    通过反射定义一个方法可以实现获取任意对象的属性值
//    如：setProperty(对象，属性名,新的属性值)    设置
//           getProperty(对象，属性名)   获取
public class Job1 {
    private int sum;
    public static void setProperth(Object o, String name, Object par) throws NoSuchFieldException, IllegalAccessException {
        Class c = o.getClass();
        Field field = c.getDeclaredField(name);
        field.setAccessible(true);
        field.set(o,par);
    }
    public static Object getProperty(Object o,String name) throws NoSuchFieldException, IllegalAccessException {
        Class c = o.getClass();
        return c.getDeclaredField(name).get(o);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Job1 job1 = new Job1();
        setProperth(job1,"sum",1);
        Object sum = getProperty(job1, "sum");
        System.out.println(sum);
    }
}

