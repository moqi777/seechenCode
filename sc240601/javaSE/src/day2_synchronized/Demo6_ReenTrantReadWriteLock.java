package day2_synchronized;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试读写锁
 * @DateTime:2024/6/25 17:18
 **/
public class Demo6_ReenTrantReadWriteLock {
    Object data;//假设这是共享的数据
    ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
    public void read(){//读取上面数据的方法
        String name = Thread.currentThread().getName();
        try {
            //获取读锁
            rwLock.readLock().lock();
            System.out.println(name+"模拟开始读取2s数据："+data);
            Thread.sleep(2000);
            System.out.println(name+"模拟读取2s数据结束："+data);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //释放读锁
            rwLock.readLock().unlock();
        }
    }
    public void write(Object data){//对上面数据进行写入的方法
        try {
            rwLock.writeLock().lock();
            String name = Thread.currentThread().getName();
            System.out.println(name+"模拟开始吸入2s数据："+data);
            this.data = data;
            Thread.sleep(2000);
            System.out.println(name+"模拟写入2s数据结束："+data);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        Demo6_ReenTrantReadWriteLock d = new Demo6_ReenTrantReadWriteLock();
        for (int i = 0; i < 4; i++) {
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    d.read();
                }
            },"读："+i).start();
            new Thread(()->{
                for (int j = 0; j < 5; j++) {
                    d.write(Math.random());
                }
            },"写："+i).start();
        }
    }
}

