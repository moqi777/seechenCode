package doudou5G.server;

import doudou5G.entity.MobileCard;
import doudou5G.util.LoginCheck;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:登录页面
 * @DateTime:2024/7/4 13:37
 **/
public class LoginView {
    public LoginView() {
        //如果cookie中存在用户跳过登录
        if (Index.nowMobileCard!=null){
            new SecondView();
            return;
        }
        System.out.println("\n**********登录**********");
        System.out.print("请输入卡号：");
        String cardNumber = Index.scanner.next();
        System.out.print("请输入密码：");
        String password = Index.scanner.next();
        //验证登录信息
        MobileCard mobileCard = LoginCheck.check(cardNumber, password);
        if (mobileCard==null) return;
        //登录成功后将用户信息保存在cookie中
        Index.nowMobileCard = mobileCard;
        //提示登录成功，并跳转二级菜单
        System.out.println("登录成功！！！");
        new SecondView();
    }
}

