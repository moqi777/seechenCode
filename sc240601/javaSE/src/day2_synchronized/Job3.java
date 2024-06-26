package day2_synchronized;

import java.util.ArrayList;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/25 20:57
 **/
/*
有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:
抽奖箱1 又产生了一个 10 元大奖
抽奖箱2 又产生了一个 100 元大奖
 */
public class Job3 {
    static int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
    static boolean[] flag = new boolean[arr.length];
    static int count = 0;

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (Job3.class) {
                System.out.println(Thread.currentThread().getName() + " ");
                while (count != arr.length) {
                    int index = (int) (Math.random() * arr.length);//随机下标
                    if (!flag[index]) {
                        System.out.println(Thread.currentThread().getName() + "又产生了一个" + arr[index] + "元大奖");
                        flag[index] = true;
                        count++;
                    }
                    if (count == arr.length) {
                        System.out.println("抽完了");
                    }
                }
            }
        },"抽奖箱1").start();

        new Thread(()->{
            synchronized (Job3.class){
                while (count != arr.length) {
                    int index = (int) (Math.random() * arr.length);//随机下标
                    if (!flag[index]) {
                        System.out.println(Thread.currentThread().getName() + "又产生了一个" + arr[index] + "元大奖");
                        flag[index] = true;
                        count++;
                    }
                    if (count == arr.length) {
                        System.out.println("抽完了");
                    }
                }
            }
        },"抽奖箱2").start();
    }
}

