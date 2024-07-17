package designMode;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/16 14:12
 **/
//CGlib动态代理：代码了解
//1.实现一个MethodInterceptor接口底层实现是别人写好的拦截器
//2.实现一个intercept() 功能等价于jdk里面的invoke()
//3.动态创建目标对象代理对象
public class CGlibProxy implements MethodInterceptor {
    //参数1：o 被代理对象
    //参数2：method    被代理对象的调用方法
    //参数3：objects   被代理方法的参数
    //参数4：methodProxy   子类代理对象 目的是用于调用目标方法 并且获取返回值
    //返回值：就是目标方法 的返回值
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("增强方法1");
        //用于表示目标方法的执行
        Object result = methodProxy.invokeSuper(o, objects);
        System.out.println("增强方法2");
        return result;
    }
    //直接动态创建目标对象(参数：目标对象的类对象)
    public Object getProxy(Class c){
        //1.创建CGlib动态代理对象实现类
        Enhancer enhancer = new Enhancer();
        //2.设置需要被子类代理的目标类
        enhancer.setSuperclass(c);
        //3.设置实现类（创建目标对象字节码文件）
        enhancer.setCallback(this);
        //4.通过ASM（小型字节码框架）将字节码文件动态创建实例
        return enhancer.create();
    }

    public static void main(String[] args) {
        //创建一个需要被代理的对象（目标对象）
        Dog dog = new Dog();
        Exam exam = new Exam();
        System.out.println("不走CGlib代理的");
        dog.eat();
        System.out.println(dog.getMsg());
        exam.add("java线程");
        exam.start();

        System.out.println("\n走CGlib代理的");
        CGlibProxy proxy = new CGlibProxy();
        Dog newDog = (Dog) proxy.getProxy(dog.getClass());
        Exam newexam = (Exam) proxy.getProxy(exam.getClass());
        newDog.eat();
        System.out.println(newDog.getMsg());
        newexam.add("JAVAIO");
        newexam.start();
    }
}
//写几个目标对象
class Dog{
    public void eat(){
        System.out.println("狗吃骨头");
    }
    public String getMsg(){
        System.out.println("获取狗信息的方法");
        return "狗信息";
    }
}
class Exam{
    public void add(String name){
        System.out.println("添加题目");
    }
    public void start(){
        System.out.println("开始考试");
    }
}
