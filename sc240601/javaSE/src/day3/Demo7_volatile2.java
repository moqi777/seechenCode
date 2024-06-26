package day3;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试 指令是否会出现重排序
 * 如果添加了volatile 是否可以禁止
 * @DateTime:2024/6/26 17:09
 **/
public class Demo7_volatile2 {
    //测试这四个变量是否出现重排
    public volatile static int a,b,c,d;
    public static void main(String[] args) throws InterruptedException {
        int i =0;
        while (true){
            i++;//计算次数
            a=b=c=d=0;//每循环一次 清零
            Thread t1 = new Thread(() -> {
                a=1;
                c=b;
                //正常来说先执行a=1 再执行 c=b
                //如果重排序后 可能先执行c=b，这时只要保持c和d都是0
                //就可以确保是否重排序了
            });
            Thread t2 = new Thread(() -> {
                b=1;
                d=a;
            });
            t1.start();
            t2.start();

            t1.join();
            t2.join();
            if(c==0 && d==0){
                System.out.println("执行了第"+i+"次出现指定重排序");
                break;
            }else {
                System.out.println(i);
            }
        }
    }
}

