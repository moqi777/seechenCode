package day3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:公平锁和非公平锁
 * @DateTime:2024/6/26 14:11
 **/
public class Demo3_justice {
    //有参构造：true表示公平锁 false(默认值)非公平锁
    ReentrantLock lock = new ReentrantLock(true);
    //读写锁 也是类似于：true/false

    public void test(){
        String name = Thread.currentThread().getName();
        try {
            lock.lock();
            System.out.println(name+"获取了锁，开始执行...");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name+"执行结束了，开始释放...");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo3_justice d = new Demo3_justice();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                while (true) d.test();
            },"线程"+i).start();
        }
    }
}

