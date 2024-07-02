package day7;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/2 19:09
 **/
//有100份礼品,两人同时发送，当剩下的礼品小于10份的时候则不再送出，利用多线程模拟该过程并将线程的名称打印出来.
public class Job1 {
    volatile static int gift = 100;//100份礼物

    public static void main(String[] args) {
        Runnable r = ()->{
            while (gift>10){
                synchronized (Job1.class){
                    System.out.println(Thread.currentThread().getName()+"发送了一份礼物,还剩"+gift--+"份礼物");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        new Thread(r,"张三").start();
        new Thread(r,"李四").start();
    }
}

