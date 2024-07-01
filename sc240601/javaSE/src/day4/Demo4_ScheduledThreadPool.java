package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:可周期定长线程池案例
 * @DateTime:2024/6/27 15:53
 **/
public class Demo4_ScheduledThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newScheduledThreadPool(3);
        //1.基础操作 execute()
//        for (int i = 0; i < 100; i++) {
//            es.execute(()->{
//                System.out.println(Thread.currentThread().getName());
//            });
//        }
//        es.shutdown();
        //2.支持延迟操作  是子类自己的方法 不能声明父类对象
        //ses.schedule(Runnable，首次延迟时间，时间单位)
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            ses.schedule(()->{
//                System.out.println(Thread.currentThread().getName());
//            },5, TimeUnit.SECONDS);
//        }
//        ses.shutdown();
        //3.支持周期操作  是子类自己的方法 不能声明父类对象
        //ses.scheduleAtFixedRate(Runnable,首次延迟时间，周期时间，时间单位)
        for (int i = 0; i < 3; i++) {
            ses.scheduleAtFixedRate(()->{
                System.out.println(Thread.currentThread().getName());
            },3,2,TimeUnit.SECONDS);
        }
        ses.shutdown();
    }
}

