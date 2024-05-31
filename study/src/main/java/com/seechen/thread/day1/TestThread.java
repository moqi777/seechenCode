package com.seechen.thread.day1;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/5/20 20:42
 **/
public class TestThread {
    public static void main(String[] args) {
        //3.创建MyThread类的对象
        MyThread my1 = new MyThread();
        MyThread my2 = new MyThread();
        //4.启动线程
        //run() 不是启动线程 只相当于对象调用方法
//        my1.run();
//        my2.run();
        //start() 是启动线程 多个线程抢CPU 谁抢到谁执run()
        my1.start();
        my2.start();
    }
}

