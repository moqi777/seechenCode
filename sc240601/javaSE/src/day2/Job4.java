package day2;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/25 20:57
 **/
/*
编写一个程序，启动三个线程，三个线程的名称分别是 A，B，C；每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABC…
 */
public class Job4 {
    public static void main(String[] args) {
        Runnable r = ()->{
            synchronized (Job4.class){
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        new Thread(r,"A").start();
        new Thread(r,"B").start();
        new Thread(r,"C").start();
    }
}

