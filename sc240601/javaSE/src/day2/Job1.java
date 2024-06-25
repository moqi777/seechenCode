package day2;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/25 20:56
 **/
//创建一个Java程序，其中定义一个共享的银行账户类`BankAccount`，
//该类有一个余额成员变量`balance`和两个方法：`deposit(int amount)`用于存款，
//`withdraw(int amount)`用于取款。创建多个线程，每个线程代表一个用户，随机
//对账户进行存款和取款操作。使用`synchronized`关键字确保账户余额的更新是线
//程安全的，并打印出每次操作后的账户余额。
//提示：
//- 在`BankAccount`类的`deposit`和`withdraw`方法上使用`synchronized`关键字来确保同一时间只有一个线程可以访问这些方法。
//- 创建多个线程，每个线程在循环中随机选择存款或取款操作，并调用相应的同步方法
public class Job1 {
    public static void main(String[] args) {
        BankAccont bankAccont = new BankAccont();
        //循环创造三个用户
        for (int i = 0; i < 3; i++) {
            new Thread(()->{
                while (true){
                    //随机一个三位数取款或存款
                    int maney = (int)(Math.random()*900)+100;
                    //随机一个个位数，如果为偶数存款，如果为奇数取款
                    if((int)(Math.random()*11)%2==0){
                        bankAccont.deposit(maney);
                    }else {
                        bankAccont.withdraw(maney);
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            },"用户"+i).start();
        }
    }
}

class BankAccont{
        int balance = 1000;//默认该账户中有一千元
        //存款
        public synchronized void deposit(int amout){
            balance += amout;
            System.out.println(Thread.currentThread().getName()+"存入"+amout+"元，现余额为"+balance+"元");
        }
        //取款
        public synchronized void withdraw(int amout){
            if(balance>amout){
                balance -= amout;
                System.out.println(Thread.currentThread().getName()+"取走"+amout+"元，现余额为"+balance+"元");
            }else {
                System.out.println(Thread.currentThread().getName()+"取走"+amout+"元失败，余额不足，现余额为"+balance+"元");
            }
        }
}
