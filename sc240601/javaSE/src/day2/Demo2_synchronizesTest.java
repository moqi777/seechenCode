package day2;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:基于synchronized同步方法实现购票功能，票的总数：100
 * 模拟两个窗口同时购票 有200个购票需求
 * @DateTime:2024/6/25 16:02
 **/
public class Demo2_synchronizesTest {
    int tickets = 100;//总数
    public synchronized void buyTicket(){
        String name = Thread.currentThread().getName();
        if (tickets>0){
        tickets -- ;
        System.out.println(name+"车票售出，剩余："+tickets);
        }
    }

    public static void main(String[] args) {
        Demo2_synchronizesTest d = new Demo2_synchronizesTest();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                d.buyTicket();
            }
        }, "窗口一");
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                d.buyTicket();
            }
        }, "窗口二");
        t1.start();
        t2.start();
        try {
            //等待t1和t2执行结束 再执行当前(main)线程
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("两个窗口购买完毕，剩余："+d.tickets);
    }
}

