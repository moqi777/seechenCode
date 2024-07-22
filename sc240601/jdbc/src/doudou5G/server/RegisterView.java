package doudou5G.server;

import doudou5G.entity.*;
import doudou5G.util.*;

import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:注册页面
 * @DateTime:2024/7/4 14:26
 **/
public class RegisterView {
    public RegisterView() {
        System.out.println("\n*****可选择卡号*****");
        String[] cardNumbers = CardNumberGen.gen();//调用工具类生产随机卡号，方法会自动输出卡号
        System.out.print("请选择卡号(输入1-9的序号)：");

        String next = Index.scanner.next();
        //判断用户是否乱输入
        int verify = ScannerYN.verify(next,1,9);
        if (verify==-1) return;
        //用户选择的号码
        String cardNumber = cardNumbers[verify-1];

        System.out.print("1.话痨套餐  2.网虫套餐  3.超人套餐  ，请选择套餐：");
        next = Index.scanner.next();
        //验证用户输入合法性
        verify = ScannerYN.verify(next, 1, 3);
        ServicePackage serPackage = null;
        if (verify==-1) return;
        switch (verify){
            case 1:serPackage = new TalkPackage(58,500,30);break;
            case 2:serPackage = new NetPackage(68,3*1024);break;
            case 3:serPackage = new SuperPackage(78,200,50,1*1024);
        }

        System.out.print("请输入姓名：");
        String userName = Index.scanner.next();
        String password = RegPasswordYN.verify();
        if (password==null) return;
        double money = RegMoneyYH.verify(serPackage);
        HashMap<String, Object> map = serPackage.showInfo();
        //创建一个用户对象，并赋值
        MobileCard mobileCard = new MobileCard(cardNumber, userName, password, serPackage, (double) map.get("price"), money,
                map.get("talkTime") == null ? 0 : (int) map.get("talkTime"),
                map.get("smsCount") == null ? 0 : (int) map.get("smsCount"),
                map.get("flow") == null ? 0 : (int) map.get("flow"));
        //将其持久化
        RegSerializable.start(mobileCard);

        //输出注册成功信息
        //计算余额
        double balance = money - (double)map.get("price");
        System.out.println("\n*******注册成功*******");
        System.out.println("卡号："+cardNumber+" 用户名："+userName+" 当前余额："+balance+"元。");
        //输出的同时调用场景，持久保存记录
        switch (verify){
            case 1:
                RegFirstScene.regTalk(cardNumber);
                System.out.println("话痨套餐：通话时长为500分钟/月，短信条数为30条/月，上网流量无。");
                break;
            case 2:
                RegFirstScene.regNet(cardNumber);
                System.out.println("网虫套餐：通话时长无，短信条数无，上网流量为3GB/月。");
                break;
            case 3:
                RegFirstScene.regSuper(cardNumber);
                System.out.println("超人套餐：通话时长为200分钟/月，短信条数为50条/月，上网流量为1GB/月。");
        }
        System.out.println("超出套餐的计费\n   通话：0.2元/分钟\n   短信：0.1元/条\n   上网流量：0.1元/MB(1GB=1024MB)");
    }
}

