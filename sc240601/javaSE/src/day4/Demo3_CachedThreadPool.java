package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:可缓存线程池
 * @DateTime:2024/6/27 15:27
 **/
public class Demo3_CachedThreadPool {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 10000; i++) {
            es.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
        //关闭线程池 不能再执行(execute) 但是里面已经开始的任务还可以再执行
        es.shutdown();
    }
}

