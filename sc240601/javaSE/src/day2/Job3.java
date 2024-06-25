package day2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

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
    static Integer[] arr = {10,5,20,50,100,200,500,800,2,80,300};

    public static void main(String[] args) {
        new Thread(()->{
            synchronized (Job3.class){
                System.out.println(Thread.currentThread().getName()+" ");
                while (arr.length>0){
                    int index = (int)(Math.random()*arr.length);//随机下标
                    System.out.println("又产生了一个"+arr[index]+"元大奖");
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = 0; i < arr.length; i++) {
                        if (i==index) continue;
                        list.add(arr[i]);
                    }
                    arr = list.toArray(new Integer[arr.length - 1]);
                }
                if(arr.length==0){
                    System.out.println("抽完了");
                }
            }
        },"抽奖箱1").start();

        new Thread(()->{
            synchronized (Job3.class){
                System.out.println(Thread.currentThread().getName()+" ");
                while (arr.length>0){
                    int index = (int)(Math.random()*arr.length);//随机下标
                    System.out.println("又产生了一个"+arr[index]+"元大奖");
                    ArrayList<Integer> list = new ArrayList<>();
                    for (int i = 0; i < arr.length; i++) {
                        if (i==index) continue;
                        list.add(arr[i]);
                    }
                    arr = list.toArray(new Integer[arr.length - 1]);
                }
                if(arr.length==0){
                    System.out.println("抽完了");
                }
            }
        },"抽奖箱2").start();
    }
}

