package day4;

import java.util.Currency;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:写两个线程，一个线程打印 1-52，另一个线程打印A-Z，保证打印顺序是12A34B…5152Z；
 * @DateTime:2024/6/27 11:04
 **/
//公平锁实现
public class Work1 {
    public void print(){
        int num = 1;
        int zimu = 65;
        ReentrantLock lock = new ReentrantLock(true);
        String name = Thread.currentThread().getName();
        try {
            lock.lock();
            if(name.equals("0")){//打印数字
                System.out.print(num+num++);
                num += 2;
            }else {//打印字母
                System.out.print((char)zimu);
                zimu++;
            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Work1 work1 = new Work1();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                work1.print();
            }
        },"0").start();
        new Thread(()->{
            for (int i = 0; i < 26; i++) {
                work1.print();
            }
        },"1").start();
    }
}

