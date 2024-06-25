package day1_Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/24 21:05
 **/
//一球从100米高度自由落下，每次落地后反跳回原高度的一半；
// 再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
// 通过线程模拟这个过程
public class Job1 {
    static double height = 100;//初始高度
    static double sum = height;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Double> c1 = ()->{
            for (int i = 1; i <= 10; i++) {
                height /= 2;
                System.out.println("第"+i+"次反弹"+height+"米");
                sum += height*2;
            }
            return sum;
        };
        FutureTask<Double> f1 = new FutureTask<>(c1);
        new Thread(f1).start();
        System.out.println("共经历了"+f1.get()+"米");
    }
}

