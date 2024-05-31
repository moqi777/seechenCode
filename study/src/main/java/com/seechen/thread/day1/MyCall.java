package com.seechen.thread.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/5/21 9:33
 **/
//1.实现Callabel接口 泛型是什么类型
public class MyCall implements Callable<String> {
    //2.实现Call() 返回值就是什么类型
    public String call() throws Exception {
        for (int i = 0; i < 100; i++) {
            System.out.println("开始吃饭："+i);
        }
        return "吃饱了";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //3. 创建MyCall对象
        MyCall my = new MyCall();
        //4. 通过FutureTast封装一下Callable接口对象
        FutureTask<String> ft = new FutureTask(my);
        //5.创建线程 通过有参构造输入FutureTast（底层实现是Runnable）
        Thread t = new Thread(ft);
        //6.启动线程
        t.start();
        //7.获取结果，会等线程执行结束了 有结果了 才会执行
        System.out.println("main1");;
        String result = ft.get();
        System.out.println("main2");
        System.out.println(result);
    }
}

