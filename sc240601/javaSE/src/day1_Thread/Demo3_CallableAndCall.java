package day1_Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:实现Callable接口 实现call()
 * @DateTime:2024/6/24 14:35
 **/
//该方式的call()类似于run()
// 与实现runable接口的方法区别在于两点：
// 1.可以有返回值，通过泛型决定返回值类型
//2.可以抛异常
public class Demo3_CallableAndCall implements Callable<Integer> {
    //返回值：执行线程时 最终可以返回一个
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i%2==0) {
                sum+=i;
                Thread.sleep(300);
                System.out.println("目前累加到："+sum);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Demo3_CallableAndCall d = new Demo3_CallableAndCall();
        //FutureTask实现了Runnable接口，它可以封装Callable来实现线程
        FutureTask<Integer> ft = new FutureTask<>(d);
        Thread t = new Thread(ft);
        t.start();
        //获取线程的执行结果：属于线程阻塞
        //需要等待call执行结束后 才会执行
        Integer sum = ft.get();
        System.out.println("计算的结果是："+sum);
    }
}

