package day1_Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/24 14:53
 **/
//Runnable
//1.请创建两个线程，完成同一个变量i从0到10万的输出
//Callable
//2.请创建两个线程，分别产生一个随机数并返回，然后返回
//提示：生成随机数方式：Math.random() 使用函数返回一个0-1之间的随机小数
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //第一题
        Runnable r1 = ()->{
            for (int i = 0; i <= 10000; i++) {
                System.out.println(Thread.currentThread().getName()+"："+i);
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r1);
        t1.start();
        t2.start();
        //第二题
        Callable<Integer> c1 = ()->{
            return (int)(Math.random()*9000+1000);
        };
        FutureTask<Integer> f1 = new FutureTask<>(c1);
        FutureTask<Integer> f2 = new FutureTask<>(c1);
        new Thread(f1).start();
        new Thread(f2).start();
        System.out.println(f1.get());
        System.out.println(f2.get());
    }
}


