package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:通过线程模拟病人看病的功能
 * @DateTime:2024/6/24 16:04
 **/
//第一类病人：是普通用户 50人 看病时长：500ms
//优先级低一些 如果普通用户看完了10人优先看完VIP用户再看普通用户
//第二类病人，是VIP用户 10人 看病时长：1000ms
//优先级高一些
public class Demo4 {
    public static void main(String[] args) {
        Thread vip = new Thread(()->{
            String name = Thread.currentThread().getName();
            for (int i = 1; i <= 10; i++) {
                System.out.println("第"+i+"个"+name+"在看病");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"VIP用户");
        Thread user = new Thread(()->{
            String name = Thread.currentThread().getName();
            for (int i = 1; i <= 50; i++) {
                System.out.println("第"+i+"个"+name+"在看病");
                try {
                    Thread.sleep(500);
                    if (i==10){
                        vip.join();//让vip用户插队
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"普通用户");
        //只有两个线程同一个时间点去抢cpu的时候 优先级高的执行
        vip.setPriority(Thread.MAX_PRIORITY);
        user.setPriority(Thread.MIN_PRIORITY);
        vip.start();
        user.start();

    }
}

