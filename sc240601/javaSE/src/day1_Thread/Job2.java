package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/24 21:20
 **/
//编制一个有3个线程的程序。
//线程1模拟温度传感器，每隔500毫秒产生并输出一个20-40的随机数，用以表示当前温度。
//线程2模拟湿度传感器，每隔400毫秒产生并输出一个70-90的随机数，用以表示当前湿度。
//线程3模拟光照传感器，每隔300毫秒产生并输出一个20-80的随机数，用以表示当前光线强度
public class Job2 {
    public static void main(String[] args) {
        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+",当前温度："+(int)(Math.random()*21+20));
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"温度传感器").start();
        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+",当前湿度："+(int)(Math.random()*21+70));
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"湿度传感器").start();
        new Thread(()->{
            while (true) {
                System.out.println(Thread.currentThread().getName()+",当前光照度："+(int)(Math.random()*61+20));
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"光照传感器").start();
    }
}

