package day2_synchronized;

import java.time.LocalTime;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/25 20:57
 **/
//创建一个Java程序，模拟一个简单的缓存系统。定义一个`Cache`类，该类有一个`Map`成员变量用于存储键值对，
//并提供读取和写入缓存的方法。创建多个线程，其中一部分线程负责向缓存中写入数据，另一部分线程负责从缓存
//中读取数据。使用`ReentrantReadWriteLock`来确保读写操作的线程安全，并优化读写性能。
//提示
//- 在`Cache`类中使用`ReentrantReadWriteLock`来同步读写操作。
//- 使用读锁来允许多个线程同时读取缓存，使用写锁来确保同一时间只有一个线程可以写入缓存。
//- 创建两类线程：一类线程负责写入数据（使用写锁），另一类线程负责读取数据（使用读锁）。
public class Job2 {
    public static void main(String[] args) {
        Cache cache = new Cache();
        for (int i = 0; i < 4; i++) {
            String k = "key:"+i;
            String v = "value:"+i;
            new Thread(()->{
                cache.write(k,v);
            },"写入"+i).start();
        }
        for (int i = 0; i < 4; i++) {
            String k = "key:"+i;
            new Thread(()->{
                cache.read(k);
            },"读取"+i).start();
        }
    }
}

class Cache{
    ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void write(String key,String value){
        try {
            rwLock.writeLock().lock();
            System.out.println(Thread.currentThread().getName()+"开始写入");
            map.put(key,value);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"写入成功");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }
    public void read(String k){
        try {
            rwLock.readLock().lock();
            System.out.println(Thread.currentThread().getName()+"开始读取：");
            System.out.println(map.get(k));
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName()+"读取结束");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }
}

