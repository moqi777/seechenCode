package day2;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:基于synchronized同步代码块实现购票功能，票的总数：100
 *  * 模拟两个窗口同时购票 有200个购票需求
 * @DateTime:2024/6/25 16:15
 **/
public class Demo3_synchronizedTest2 implements Runnable{
    int tickets=100;
    public void run(){
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 100; i++) {
            //购买一张票
            synchronized (this){
                if (tickets>0){
                    tickets--;
                    System.out.println(name+"售票成功，剩余："+tickets);
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo3_synchronizedTest2 d = new Demo3_synchronizedTest2();
        new Thread(d,"窗口一").start();
        new Thread(d,"窗口二").start();
    }
}

