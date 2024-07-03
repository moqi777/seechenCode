package day8;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:单例模式
 * @DateTime:2024/7/3 10:11
 **/
public class Demo1_danli {
    public static void main(String[] args) {
        Instance i1 = Instance.get();
        Instance i2 = Instance.get();
        System.out.println(i1);
        System.out.println(i2);
    }
}

class Instance{
    //单例模式中：饿汉式 对象无论是否使用都先创建出来
    private static Instance is = new Instance();
    //阻止其他类不能 new对象
    private Instance(){}
    //对外提供一个公开的方法返回一个对象
    public static Instance get(){
        return is;
    }
}

class Instance2{
    //单例模式中：懒汉式 对象先不创建 什么时候使用什么时候创建
    //隐患：多线程情况下 可能会有并发问题 （可能会同时进if，有可能创建多个对象）
    //解决方案：同步锁
    private static Instance2 is;
    //阻止其他类不能 new对象
    private Instance2(){}
    //对外提供一个公开的方法返回一个对象
    public synchronized static Instance2 get(){
        if(is==null) is=new Instance2();
        return is;
    }
}

class Instance3{
    //单例模式中：双重检索模式 是由于单纯的懒汉式添加了同步锁 会导致效率比较低
    //而双重检索 其实就是对懒汉式做了个优化
    //添加两个判断来控制 提高同步锁的效率
    private volatile static Instance3 is;
    private Instance3(){}
    public static Instance3 get(){
        if(is==null){//是为了解决如果对象存在 不用同步锁 直接返回效率高
            synchronized (Instance3.class){//如果为null 添加同步锁 访问其他线程无法创建对象
                if(is==null){//如果当前线程获取对象 再创建对象发现已经不是null 无需再创建了
                    is = new Instance3();
                }
            }
        }
        return is;
    }
}

class Instance4{
    //单例模式：静态内部类实现，优势 使用静态内部类
    // 内部类加载只做一次 所以里面的对象也只会创建一次
    //外部类只要通过内部类的类名.属性名
    private Instance4(){}
    private static class My{//静态内部类
        private static Instance4 is = new Instance4();
    }
    public static Instance4 get(){
        return My.is;
    }
}

enum Instance5{
    //单例模式：枚举 只要提供一个常量 永远只会调用一次构造
    AAA;
    private Instance5(){};
    public static Instance5 get(){
        return AAA;
    }
}