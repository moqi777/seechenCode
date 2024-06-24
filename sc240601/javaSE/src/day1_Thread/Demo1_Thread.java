package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:继承Thread类 重写run()
 * @DateTime:2024/6/24 11:28
 **/
//在java中 跟Thread相关的类 才是线程 才能使用线程的常用方法
public class Demo1_Thread extends Thread{
    //run() 就表示线程执行逻辑
    public void run() {
        //通过当前执行的线程 来 获取线程名称
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(name+" "+i);
        }
    }

    //运行main() 也会默认启动一个线程（主线程）
    public static void main(String[] args) {
        Demo1_Thread demo1 = new Demo1_Thread();
        demo1.setName("线程一");//设置线程的名字
        Demo1_Thread demo2 = new Demo1_Thread();
        demo2.setName("线程二");
        //面试题和笔试题：run()和start()区别
        //这种方式不是线程的开启，只是对象名调用方法
        //执行顺序 一定是固定的 ->demo1.run() ->deme2.run()
        //demo1.run();
        //demo2.run();
        //这种方式才是线程的开启，是交替抢占CPU的执行顺序可能是不同的
        demo1.start();
        demo2.start();
    }
}

