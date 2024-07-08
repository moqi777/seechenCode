package doudou5G.server;
import doudou5G.entity.*;
import doudou5G.util.SelectMobileCardToCardNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:使用兜兜5G
 * @DateTime:2024/7/6 9:55
 **/
public class UseDouDou5GView {
    public UseDouDou5GView() {
        // 预定一些场景在集合中
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene("通话", -90, "问候客户，谁知其如此难缠，通话90分钟"));
        scenes.add(new Scene("短信", -50, "通知朋友手机换号，发送短信50条"));
        scenes.add(new Scene("短信", -5, "参与环境保护实施方案问卷调查，发送短信5条"));
        scenes.add(new Scene("流量", -500, "晚上睡不着觉，打了一晚上游戏，用了500MB流量"));
        scenes.add(new Scene("通话", -30, "与家人通话30分钟"));
        scenes.add(new Scene("流量", -1000, "视频通话1小时，用了1000MB流量"));
        scenes.add(new Scene("短信", -10, "发送新年祝福短信10条"));
        scenes.add(new Scene("通话", -20, "客服热线通话20分钟"));
        scenes.add(new Scene("流量", -300, "在线听音乐，用了300MB流量"));
        scenes.add(new Scene("通话", -45, "与朋友聊天45分钟"));
        scenes.add(new Scene("流量", -200, "浏览社交媒体，用了200MB流量"));
        scenes.add(new Scene("短信", -15, "提醒客户会议时间，发送短信15条"));
        scenes.add(new Scene("流量", -250, "观看在线直播，用了250MB流量"));
        scenes.add(new Scene("通话", -10, "医生预约通话10分钟"));
        scenes.add(new Scene("短信", -5, "短信验证5条"));
        scenes.add(new Scene("流量", -400, "下载大文件，用了400MB流量"));

        System.out.print("请输入手机卡号：");
        String cardNumber = Index.scanner.next();
        // 从列表中随机选择一个元素
        Random random = new Random();
        Scene randomScene = scenes.get(random.nextInt(scenes.size()));
        //获取该手机号套餐
        MobileCard select = SelectMobileCardToCardNumber.select(cardNumber);
        //如果用户不存在返回提示
        if (select==null) {
            System.out.println("错误输入或该号码未注册");
            return;
        }
        ServicePackage serPackage = select.getSerPackage();
        //输出该场景
        System.out.println(randomScene.getDescription());
        //执行根据随机到的不同场景的对应操作
        switch (randomScene.getType()){
            case "通话":
                //instanceof关键字：用于测试一个对象是否是某个类的实例
                // 超人套餐支持所有功能，无需判断，需要判断是网虫套餐还是话痨套餐
                if (serPackage instanceof NetPackage){//如果用户是网虫套餐，就不能通话
                    System.out.println("错误：当前套餐不支持此类消费，如需使用请更改为话痨套餐或升级为超人套餐(当前为网虫套餐)");
                    return;
                }
                //在此均使用超人套餐下的功能方法（也可使用对应的话痨套餐下的方法）
                new SuperPackage().call(randomScene.getData(),cardNumber);
                break;
            case "短信":
                if (serPackage instanceof NetPackage){//如果用户是网虫套餐，就不能发短信
                    System.out.println("错误：当前套餐不支持此类消费，如需使用请更改为话痨套餐或升级为超人套餐(当前为网虫套餐)");
                    return;
                }
                //在此均使用超人套餐下的功能方法（也可使用对应的话痨套餐下的方法）
                new SuperPackage().send(randomScene.getData(),cardNumber);
                break;
            case "流量":
                if (serPackage instanceof TalkPackage){//如果用户是话痨套餐，就不能上网
                    System.out.println("错误：当前套餐不支持此类消费，如需使用请更改为网虫套餐或升级为超人套餐(当前为话痨套餐)");
                    return;
                }
                //在此均使用超人套餐下的功能方法（也可使用对应的网虫套餐下的方法）
                new SuperPackage().netPlay(randomScene.getData(),cardNumber);
        }

    }
}

