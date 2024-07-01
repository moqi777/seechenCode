package day4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:可定长线程池
 * @DateTime:2024/6/27 14:56
 **/
public class Demo2_FixedThreadPool {
    public static void main(String[] args) {
//        ExecutorService es = Executors.newFixedThreadPool(3);//参数表示最高支持并发数量
//        es.execute(()->{
//            for (int i = 0; i < 10; i++) {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        es.shutdown();
        //有一个餐厅 需要做5盘菜 一共提供了三个灶台 一次性炒3盘菜
        //最后统计一下 炒5盘菜 一共花了多少时间
        ExecutorService es = Executors.newFixedThreadPool(3);
//        ExecutorService es = Executors.newCachedThreadPool();
        long[] times = {1000,3000,3000,4000,2000};
        String[] names = {"蛋炒饭","辣椒炒肉","糖醋排骨","肉沫茄子","鸡蛋羹"};
        //获取当前的时间毫秒数
        long start=System.currentTimeMillis();
        for (int i = 0; i < times.length; i++) {
            int index = i;
            es.execute(()->{
                System.out.println("开始做"+names[index]);
                try {
                    Thread.sleep(times[index]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("已经做好了"+names[index]);
            });
        }
        es.shutdown();
        while (true){//死循环 监听线程池是否执行结束了
            //用来判断线程池是否关闭的 同时线程池里面的任务有没有完成
            //如果没有完成返回false 否则true
            if(es.isTerminated()){
                long end = System.currentTimeMillis();
                System.out.println("所有菜已经做完了，花费："+(end-start)+"s");
                break;
            }
        }
    }
}

