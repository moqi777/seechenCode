package com.seechen.thread.day1;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:练习：请通过继承Thread实现线程 创建三个线程 分别输入 A B C 不能停止
 * @DateTime:2024/5/20 20:57
 **/
public class Practice1 extends Thread {
    public Practice1(String name) {
        //使用父类的有参构造 设置线程name
        super(name);
    }

    @Override
    public void run() {
        while (true){
            //获取线程名 分别赋值成A B C
            String name = Thread.currentThread().getName();
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        Practice1 d1 = new Practice1("A");
        Practice1 d2 = new Practice1("B");
        Practice1 d3 = new Practice1("C");
        d1.start();
        d2.start();
        d3.start();
    }
}

