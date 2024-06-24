package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:实现Runnable接口 实现run()
 * @DateTime:2024/6/24 11:45
 **/
//它不是线程 只是线程的执行规则，如果创建线程还是要借助于Thread
public class Demo2_Runnable implements Runnable{
    public void run() {
        String name = Thread.currentThread().getName();
        for (int i = 0; i < 10; i++) {
            System.out.println(name+" "+i);
        }
    }

    public static void main(String[] args) {
        Demo2_Runnable d = new Demo2_Runnable();//d是执行规则
        Thread t = new Thread(d);//t才是线程
        Thread t2 = new Thread(d);
        t.start();
        t2.start();
    }
}

