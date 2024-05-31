package com.seechen.thread.day1;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:练习2：通过创建线程第二种方式 创建两个线程 完成变量i从0输出10万
 * @DateTime:2024/5/21 9:13
 **/
public class Practice2 {
    public static void main(String[] args) {
        Runnable r = ()->{
            String name = Thread.currentThread().getName();
            for (int i = 0; i <= 100000; i++) {
                System.out.println(name + "====" + i);
            }
        };
        Thread t1 = new Thread(r,"线程一");
        Thread t2 = new Thread(r,"线程二");
        t1.start();
        t2.start();
    }
}

