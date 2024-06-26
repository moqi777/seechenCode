package day3;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:死锁案例
 * @DateTime:2024/6/26 15:55
 **/
public class Demo5 {
    public static void main(String[] args) {
        Demo5 d1 = new Demo5();
        Demo5 d2 = new Demo5();
        new Thread(()->{
         synchronized (d1){
             System.out.println("线程1获取d1锁，等待获取d2的锁");
             try {
                 Thread.sleep(100);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             synchronized (d2){
                 System.out.println("线程1获得d1和d2两把锁");
             }
             System.out.println("线程1释放了d2的锁");
         }
            System.out.println("线程1释放了d1的锁");
        }).start();
        new Thread(()->{
         synchronized (d2){
             System.out.println("线程2获取d2锁，等待获取d1的锁");
             synchronized (d1){
                 System.out.println("线程2获得d2和d1两把锁");
             }
             System.out.println("线程2释放了d1的锁");
         }
            System.out.println("线程2释放了d2的锁");
        }).start();
    }
}

