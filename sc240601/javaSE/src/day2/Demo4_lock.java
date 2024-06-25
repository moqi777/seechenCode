package day2;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试lock锁
 * @DateTime:2024/6/25 16:27
 **/
public class Demo4_lock {
    //lock锁：有排他锁功能 也有公平锁和非公平锁的功能
    //加上static实现new多个对象实现同一把锁
    static ReentrantLock lock = new ReentrantLock();
    public void test(){
        String name = Thread.currentThread().getName();
        try {
            lock.lock();//加锁
            System.out.println(name+"开始执行");
            Thread.sleep(5000);
            System.out.println(name+"结束执行");
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //释放锁 为了防止异常发生没有关闭 会写在finally里面
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Demo4_lock d = new Demo4_lock();
        Demo4_lock d2 = new Demo4_lock();
        new Thread(()->{
            d.test();
        },"张三").start();
        new Thread(()->{
            d2.test();
        },"李四").start();
    }
}

