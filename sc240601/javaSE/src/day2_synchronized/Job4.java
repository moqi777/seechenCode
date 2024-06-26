package day2_synchronized;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/25 20:57
 **/
/*
编写一个程序，启动三个线程，三个线程的名称分别是 A，B，C；每个线程将自己的名称在屏幕上打印5遍，打印顺序是ABCABC…
 */
public class Job4 {
    int a = 1;//1打印A 2打印B 3打印C
    int countA;
    int countB;
    int countC;
    public synchronized int printA(){
        if(a==1){
            System.out.println("A");
            a=2;
            countA++;
        }
        return countA;
    }
    public synchronized int printB(){
        if(a==2){
            System.out.println("B");
            a=3;
            countB++;
        }
        return countB;
    }
    public synchronized int printC(){
        if(a==3){
            System.out.println("C");
            a=1;
            countC++;
        }
        return countC;
    }
    public static void main(String[] args) {
        Job4 job4 = new Job4();
        new Thread(()->{
            while (true){
                int count = job4.printA();
                if (count==5) break;
            }
        }).start();
        new Thread(()->{
            while (true){
                int count = job4.printB();
                if (count==5) break;
            }
        }).start();
        new Thread(()->{
            while (true){
                int count = job4.printC();
                if (count==5) break;
            }
        }).start();
    }
}

