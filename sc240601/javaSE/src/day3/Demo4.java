package day3;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:乐观锁CAS
 * @DateTime:2024/6/26 14:37
 **/
public class Demo4 {
    //通过java内置线程安全计数器
    AtomicInteger count = new AtomicInteger(0);
    public void increment(){
        String name = Thread.currentThread().getName();
        int currentValue;//当前值
        int newValue;//保存新的值
        while (true){
            currentValue = count.get();//获取当前的值
            newValue = currentValue+1;//如果可以修改 要把计数器的数字修改
            //表示尝试修改：计数器的值 和 currentValue 是一样的 没有被人修改过
            //计数器的值更新成 newValue 否则更新失败
            boolean b = count.compareAndSet(currentValue, newValue);
            if(b) break;
            else System.out.println(name+"尝试更新 但是更新失败，当前值："+currentValue+"，它已经被其他线程更新成"+count.get());
        }
    }

    public static void main(String[] args) {
        Demo4 d = new Demo4();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                d.increment();
            }
        }, "A");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                d.increment();
            }
        }, "B");
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("最终结果计数器的值："+d.count);
    }
}

