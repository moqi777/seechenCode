package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:守护线程案例
 * @DateTime:2024/6/24 14:17
 **/
public class GuardDemo {
    public static void main(String[] args) {
        Runnable r1=()->{
            while (true){
                try {
                    //控制线程睡眠时间 单位是毫秒
                    //异常不能抛只能try-catch，原因：父类的run()方法没有抛，作为子类的run()也无法
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("守护线程开始执行了");
            }
        };
        Runnable r2=()->{
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        };
        Thread t1 = new Thread(r1);
        t1.setDaemon(true);//设置守护线程，注意要在start前设置，否则会守护线程失效
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}

