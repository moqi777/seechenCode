package designMode;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:JDK动态代理实现，代码了解即可
 * @DateTime:2024/7/16 11:14
 **/
//1.通过代理类 实现InvocationHandler接口
//2.重写invoke()  目的是为了调用目标对象，还能做增强处理
//3.可有可无    动态创建目标对象
public class JDKProxy implements InvocationHandler{
    //定义私有成员变量 可以表示 不同的目标对象
    private Object o;
    public JDKProxy(Object o){
        this.o=o;
    }
    //参数1：proxy     表示代理对象
    //参数2：method    目标对象所调用的方法
    //参数3：args      目标对象调用方法的参数
    //返回值：目标对象调用方法的返回值
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("增强功能1");
        //完成目标方法的调用
        Object result = method.invoke(o,args);
        System.out.println("增强功能2");
        return result;
    }

    //3.动态的创建目标对象 可有可无
    public Object getProxy(){
        //1.获取目标对象的类加载器
        //s.getClass().getClassLoader();
        //2.获取目标对象的接口
        //s.getClass().getInterfaces();
        //3.处理目标对象的代理类
        //new JDKProxy(s);
        return Proxy.newProxyInstance(
                o.getClass().getClassLoader(),
                o.getClass().getInterfaces(),
                this    //等价于new JDKProxy()
        );
    }

    public static void main(String[] args) {
        //如果不做第三步 jdk动态代理测试 会复杂点
        Student s = new Student();
        //测试不走代理
        s.ktv();
        s.play();
        System.out.println();
        //没做第三步的测试方式
        Play newS = (Play) Proxy.newProxyInstance(
                s.getClass().getClassLoader(),
                s.getClass().getInterfaces(),
                new JDKProxy(s)
        );
        newS.play();
        newS.ktv();
        System.out.println();
        //做了第三步的测试方法
        Play play = (Play) new JDKProxy(s).getProxy();
        play.ktv();
        play.play();

        System.out.println("\n测试另一个代理类");
        Student2 s2 = new Student2();
        Study study = (Study) new JDKProxy(s2).getProxy();
        study.java();
        study.mysql();
    }
}
//目标对象接口：是可以任意的（前提：jdk动态代理实现目标对象必须要实现接口）
interface Play{
    public void play();  //玩游戏的方法
    public void ktv(); //唱歌
}
//目标对象：是可以任意的
class Student implements Play{
    public void play() {
        System.out.println("学生开始出去班级团建");
    }
    public void ktv() {
        System.out.println("学生开始KTV唱歌");
    }
}

//新的目标接口和目标对象
interface Study{
    public void java();
    public void mysql();
}
class Student2 implements Study{
    public void java() {
        System.out.println("学生开始学习java技术");
    }
    public void mysql() {
        System.out.println("学生开始学习mysql技术");
    }
}
