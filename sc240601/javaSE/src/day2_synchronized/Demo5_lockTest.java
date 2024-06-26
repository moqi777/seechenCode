package day2_synchronized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:通过lock锁实现购票功能
 * @DateTime:2024/6/25 16:40
 **/
public class Demo5_lockTest {
    ReentrantLock lock = new ReentrantLock();
    int tickets = 100;
    public void buyTicket(){
        //lock()：获取锁 获取不到一直等待
        //下面两种方式可以防止死锁
        //tryLock()：尝试获取锁 如果获取不到 不要了
        //tryLock(时间，单位)：尝试获取锁时间 如果锁时间过后获取不到 不要了
        try {
            lock.lock();
            if (tickets > 0) {
                tickets--;
                System.out.println(Thread.currentThread().getName()+"卖出了一张票，还剩："+tickets);
            }
        }finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) {
        Demo5_lockTest d = new Demo5_lockTest();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
            d.buyTicket();
            }
        },"张三").start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
            d.buyTicket();
            }
        },"李四").start();
    }
}

