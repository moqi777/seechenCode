package day3;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试volavile原子性
 * @DateTime:2024/6/26 16:44
 **/
public class Demo6_volatile implements Runnable{
    private volatile int count;//模拟购物车物品数量
    public void run() {
        for (int i = 0; i < 100; i++) {
            //count++等价于count=count+1;
            //包含1.读取count变量 2.计算count+1数值 3.给count重新赋值
            //所以它属于复合操作
            //数据丢失原因：假设线程1和2都先读取数据 都需要经过count+1计算
            //突然线程2先count进行赋值 后来线程1开始赋值的时候 还认为是原来的值
            //再次赋值的时候 数据就会丢失
            //解决方案：让这种复合操作添加同步锁
            synchronized (this){
                count++;
                System.out.println("购物车物品数量："+count);
            }
        }
    }

    public static void main(String[] args) {
        Demo6_volatile d = new Demo6_volatile();
        for (int i = 0; i < 100; i++) {
            new Thread(d).start();
        }
    }
}

