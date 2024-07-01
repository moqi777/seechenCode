package day4;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:通过可周期定长线程池：模拟燃放烟花的过程
 * 首先点燃引线需要5s 之后每2s 发射一个烟花
 * 一共有12个烟花 烟花发射完毕 打印新年快乐
 * @DateTime:2024/6/27 16:11
 **/
public class Demo5_ScheduledThreadPool_Test {
    //volatile static int count=12;   //控制烟花的数量
    static AtomicInteger count = new AtomicInteger(12);   //线程安全的计数器
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        System.out.println("点燃了烟花的引线！！！");
        ses.scheduleAtFixedRate(()->{
            if (count.get()==12) System.out.println("开始发射烟花了！！！");
            System.out.println("正在发射第"+(13-count.get())+"枚烟花");
            //count--;
            count.getAndDecrement();
        },5,2, TimeUnit.SECONDS);
        while (count.get()!=0){}   //监听烟花是否是最后一枚
        System.out.println("烟花燃放完毕，新年快乐！！！");
        ses.shutdown();
    }
}

