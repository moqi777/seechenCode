package day3;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试volavile可见性
 * @DateTime:2024/6/26 17:33
 **/
public class Demo8_volatile3 {
    public static void main(String[] args) {
        //运行后程序不会停止，会一直while循环
        new My1().start();
        new My2().start();
    }
}
class Money{
    public static int money=100000;
}
class My1 extends Thread{
    public void run() {
        while (Money.money==100000){
            //当my1中使用了money，会刷新工作内存中的值，所以会停止while循环
            //System.out.println(Money.money);
        }
        System.out.println("我的存款被偷了已经不是十万了");
    }
}
class My2 extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Money.money = 50000;
    }
}
    //主内存：线程访问共享变量的位置
    //线程工作内存：每个线程运行都有一个自己独立的空间，用于执行自己线程的内容

    //原因在于：当变量money没有被volatile修饰的时候
    //my1先开始 先把主内存money变量 读取到自己工作内存中去
    //my2睡眠1秒后 去修改money变量的值 先在自己的工作内存去修改 再去同步主内存的值
    //money修改成5000后，my1线程由于不知道对方的工作内存的结果
    //认为他一直是10000

    //当变量money被volavite修饰的时候
    // my2修改后，主内存的值也会刷新
    //my1的工作内存money变量会失效 强制刷新主内存的值
    //my2修改了 my1就可见了
    //while循环也就停止了

