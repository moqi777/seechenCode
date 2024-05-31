package com.seechen.thread.day1;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/5/20 22:11
 **/
//1. 实现Runnable接口   只是用于实现线程的执行逻辑
public class MyRun implements Runnable{
    //2. 实现抽象方法     执行逻辑的过程
    public void run() {
        //获取当前线程名
        String name = Thread.currentThread().getName();
        for (int i=0;i<100;i++){
            System.out.println(name+"："+i);
        }
    }

    public static void main(String[] args) {
        //3. 创建MyRun类的对象    执行规则
        MyRun r = new MyRun();
        //4. 创建Thread类的对象 将MyRun对象 有参构造 传入
        Thread t1 = new Thread(r,"线程一");
        Thread t2 = new Thread(r,"线程二");
        Thread t3 = new Thread(r,"线程三");
        Thread t4 = new Thread(()->{
            for(int i=0;i<100;i++){
                String name = Thread.currentThread().getName();
                System.out.println(name+"===="+i);
            }
        });
        //5 启动线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();

        /*
        //jdl1.8 lambda表达式
        //lambda是为了表述函数式接口（一个接口 只有一个抽象方法）
        MyInterface3 my3 = new MyInterface3(){
            @Override
            public void test() {

            }
        };
        //lambda语法规则：(方法参数)-> 方法的实现部分
        MyInterface3 my33 = () ->{
            System.out.println("你好啊");
        };
        my33.test();

        //并且lambda表达式 参数类型是可以省略的
        MyInterface4 my4 = (a,b)->{
            System.out.println(a+"====="+b);
        };
        my4.test("string",100);
         */
    }
}

//不是函数式接口：没有抽象方法
interface MyInterface{

}
//不是函数式接口：有两个抽象方法
interface MyInterface2{
    public void test();
    public void test2();
}
//是函数式接口，因为只有一个抽象方法
@FunctionalInterface
interface MyInterface3{
    public void test();
    public default void test2(){

    }
}
//是函数式接口，因为只有一个抽象方法
@FunctionalInterface
interface MyInterface4{
    public void test(String a,Integer b);
}