package day5;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/28 10:31
 **/
//利用周期定长线程池来模拟双色球(6个红球(1-33之间)  1个蓝球(1-16之间))摇奖过程,
// 首先双色球摇奖开始需要5S，之后每隔2S摇出一个红球  最后摇出一个蓝球  摇奖完毕后
//打印最终 双色球所有红球和蓝球.
//拓展: 也可以摇奖之前添加一个用户输入红球和蓝球的环节最终统计中了几个球
public class Work1 {

    public static void main(String[] args) {
        Random r = new Random();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()->{
            int red = r.nextInt(33)+1;//定义红球
            int blue = r.nextInt(16)+1;//定义红球
        },5,2, TimeUnit.SECONDS);
    }
}

