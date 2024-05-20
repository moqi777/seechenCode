package com.seechen.thread.day1;

import java.util.concurrent.Executor;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/5/17 17:17
 **/
//1、继承Thread类
public class MyThread extends Thread{
    //2、重写run() 用来实现 线程的执行逻辑
    //run()不能抛异常，因为父类没有抛异常，子类不能比父类抛出更大的异常
    public void run() {
        System.out.println("开始执行线程");
        for (int i=3;i>0;i--){
            System.out.println("正在执行，剩余多少"+i+"秒");
            try {
                Thread.sleep(1000);//休眠一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("线程执行结束");
    }

}

//定义异常：检查性异常    编译会出现   异常机制必须处理
class My1 extends Exception{

}
//定义异常：运行时异常    运行时可能报错 异常机制可以不处理
class My2 extends RuntimeException{

}
//如何处理异常：1抛出 2捕获
class TestMt12{
    public static void main(String[] args){
        try {
            throw new My1();
        } catch (My1 my1) {
            my1.printStackTrace();
        }
    }
}
