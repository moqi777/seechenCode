package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/30 19:11
 **/
//请通过定长线程池来模拟100个人再 三个购票窗口 排队买票的过程
public class Job1 {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 100; i++) {
            int index = i;
            es.execute(()->{
                String name = Thread.currentThread().getName();
                System.out.println(name+"：第"+index+"个人买票");
            });
        }
        es.shutdown();
    }
}

