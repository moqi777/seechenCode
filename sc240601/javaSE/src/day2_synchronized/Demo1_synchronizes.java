package day2_synchronized;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:静态同步方法 和 同步方法
 * @DateTime:2024/6/25 15:23
 **/
public class Demo1_synchronizes {
    //同步方法：锁的是this
    public synchronized void AAA(){
        String name = Thread.currentThread().getName();
        System.out.println(name+"开始执行A方法");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"结束执行A方法");
    }
    //同步方法：锁this
    public synchronized void BBB(){
        String name = Thread.currentThread().getName();
        System.out.println(name+"开始执行B方法");
        System.out.println(name+"结束执行B方法");
    }
    //静态同步方法：锁当前类对象Demo1_synchronized.class
    public static synchronized void CCC(){
        String name = Thread.currentThread().getName();
        System.out.println(name+"开始执行C方法");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(name+"结束执行C方法");
    }

    public static void main(String[] args) {
        Demo1_synchronizes d = new Demo1_synchronizes();

        new Thread(()->{
            synchronized (Demo1_synchronizes.class){
                String name = Thread.currentThread().getName();
                System.out.println(name+"开始执行D同步代码块");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(name+"结束执行D同步代码块");
            }
        },"D").start();

        new Thread(()->{
            d.AAA();
        },"A").start();
        new Thread(()->{
            d.BBB();
        },"B").start();
        new Thread(()->{
            d.CCC();
        },"C").start();
    }
/*
运行结果
A开始执行A方法    A执行的时候锁的是this 不影响C的执行
C开始执行C方法    所以C可以在A不影响的情况下执行
A结束执行A方法
B开始执行B方法
B结束执行B方法
C结束执行C方法
 */
}

