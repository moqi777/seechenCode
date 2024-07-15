package designMode;

import doudou5G.util.RegSerializable;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:静态代理案例代码
 * @DateTime:2024/7/13 17:01
 **/
public class StaticProxy implements Subject{
    private RealSubject sub = new RealSubject();
    //代理对象 调用原来方法的逻辑 + 增强处理
    public void request() {
        //加一段代码
        System.out.println("额外功能1");
        //调用原来方法的逻辑
        sub.request();
        //再加一段代码
        System.out.println("额外功能2");
    }

    public static void main(String[] args) {
        //走代理的结果
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.request();
        //不走代理的结果
        Subject sub = new RealSubject();
        sub.request();
    }
}
//对象接口
interface Subject{
    public void request();
}
//具体被代理的对象
class RealSubject implements Subject{
    public void request() {
        System.out.println("原来的这个对象，执行请求逻辑");
    }
}

