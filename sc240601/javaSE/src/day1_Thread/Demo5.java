package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/24 16:25
 **/
//创建三个线程 线程名分别是ABC 每个线程只打印名称
//要求启动三个线程 无论如何运行结果都是：ABC
public class Demo5 {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            System.out.println(Thread.currentThread().getName());
        },"A");
        Thread t2 = new Thread(()->{
            try {
                t1.join();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B");
        Thread t3 = new Thread(()->{
            try {
                t2.join();
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"C");
        t1.start();
        t2.start();
        t3.start();
    }
}

