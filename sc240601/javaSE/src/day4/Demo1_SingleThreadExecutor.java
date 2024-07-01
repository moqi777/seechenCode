package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:单线程池案例
 * @DateTime:2024/6/27 14:47
 **/
public class Demo1_SingleThreadExecutor {
    //模拟多人进洞
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            es.execute(()->{
                String name = Thread.currentThread().getName();
                System.out.println(name+"开始进洞");
                for (int j = 3; j >0 ; j--) {
                    System.out.println(name+"还需要"+j+"s...");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(name+"开始出洞");
            });
        }
        es.shutdown();
    }
}

