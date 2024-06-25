package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/24 21:31
 **/
//两个人AB通过一个账号A在柜台取钱和B在ATM机取钱 总金额自定义1000元
//   A专门 在银行取钱200    B专门在ATM取钱100    直到金额不足时结束
public class Job3 {
    static int maney = 1000;
    public static void main(String[] args) {
        new Thread(()->{
            while (maney>=200){
                maney -=200;
                synchronized (Job3.class){
                    System.out.println(Thread.currentThread().getName()+"取走了200，还剩"+maney+"元");
                }
            }
            System.out.println(Thread.currentThread().getName()+"取款失败，金额不足，结束");
        },"A").start();
        new Thread(()->{
            while (maney>=100){
                maney -=100;
                synchronized (Job3.class){
                    System.out.println(Thread.currentThread().getName()+"取走了100，还剩"+maney+"元");
                }
            }
            System.out.println(Thread.currentThread().getName()+"取款失败，金额不足，结束");
        },"B").start();
    }
}

