package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/30 19:29
 **/
//某某银行,周末客户非常多,周一到周五工作日反而没有多少用户办理业务
//为了提高 效率  银行办业务的窗口随时可以添加   请通过可缓存线程池
//模拟工作日和周末办理业务的逻辑
public class Job2 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int monday = 1;;monday++){
            System.out.println("今天是星期"+monday);
            int finalMonday = monday;
            es.execute(()->{
                if (finalMonday >=1 && finalMonday <=5){//周一到周五
                    for (int i = 0; i < 100; i++) {//平时就二十个人
                        System.out.println("窗口："+Thread.currentThread().getName()+"正在办理今天第"+i+"个业务");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }else {//周末
                    for (int i = 0; i < 2000; i++) {//周末有两百个人
                        System.out.println("窗口："+Thread.currentThread().getName()+"正在办理今天第"+i+"个业务");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
            try {
                Thread.sleep(1000);//每天一秒钟
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(monday==7) monday=1;//循环周次
        }
    }
}

