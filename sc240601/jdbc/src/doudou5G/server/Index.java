package doudou5G.server;

import doudou5G.entity.MobileCard;

import java.util.Scanner;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:项目主页面
 * @DateTime:2024/7/4 11:22
 **/
public class Index {
    public static Scanner scanner = new Scanner(System.in);
    public static MobileCard nowMobileCard = null;//当前登录的用户
    //用于执行延迟关闭的线程池和线程变量，预先创建好共享变量方便停止执行延迟线程操作和关闭线程池
    public static ScheduledExecutorService ses;
    public static ScheduledFuture<?> scheduledFuture;
    public static void start(){
        while (true){
            System.out.println("\n*************欢迎使用兜兜5G移动业务大厅************");
            System.out.println("1.用户登录  2.用户注册  3.使用兜兜5G  4.话费充值  5.资费说明  6.退出系统");
            System.out.print("请选择：");
            //所有都输入字符串，防止用户乱输入报错，保证项目的健壮性
            String next = scanner.next();
            switch (next){
                case "1":new LoginView();break;
                case "2":new RegisterView();break;
                case "3":new UseDouDou5GView();break;
                case "4":new TopUpView();break;
                case "5":new SelectPackageView();break;
                case "6": System.out.println("谢谢使用！");return;
                default: System.out.println("错误输入！！！");
            }
        }
    }
}

