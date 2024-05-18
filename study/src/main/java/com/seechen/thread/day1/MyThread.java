package com.seechen.thread.day1;

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
    @Override
    public void run() {
        System.out.println("开始执行线程");
        Thread.sleep(1000);//休眠一秒
        System.out.println("正在执行，剩余");
    }
}

