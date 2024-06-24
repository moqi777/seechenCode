package day1_Thread;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/24 21:44
 **/
//通过多线程模拟两人爬山，每个线程表示一个人，
// 可以设置爬山速度  每爬完100米显示信息 先到终点的是胜利者，
// 如果有人已经到达重点了 另一个人则停止爬山
public class Job4 {
    static int a_height = 800;//a的剩余爬行高度
    static int b_height = 800;//b的剩余爬行高度
    static volatile boolean finished = false;//标记是否有人到终点了
    //爬山速度都是50m/h
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            while (a_height>0 && !finished){
                a_height -= 50;
                if (a_height%100 == 0) System.out.println(Thread.currentThread().getName()+"剩余"+a_height+"米");
                if(a_height==0) {
                    System.out.println(Thread.currentThread().getName()+"到达了终点，是胜利者");
                    finished = true;
                }
            }
        },"A");
        Thread t2 = new Thread(()->{
            while (b_height>0 && !finished){
                b_height -= 50;
                if (b_height%100 == 0) System.out.println(Thread.currentThread().getName()+"剩余"+b_height+"米");
                if(b_height==0) {
                    System.out.println(Thread.currentThread().getName()+"到达了终点，是胜利者");
                    finished = true;
                }
            }
        },"B");
        t1.start();
        t2.start();
    }
}

