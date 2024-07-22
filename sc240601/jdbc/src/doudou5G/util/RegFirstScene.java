package doudou5G.util;

import doudou5G.entity.ConsumInfo;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:注册时初始化账单 添加初始套餐消费记录
 * @DateTime:2024/7/5 11:02
 **/
public class RegFirstScene {
    //注册话痨套餐场景，对指定用户添加一条消费记录
    public static void regTalk(String cardNumber){
        ConsumInfo cons1 = new ConsumInfo(cardNumber, "通话", 500);
        ConsumInfo cons2 = new ConsumInfo(cardNumber, "短信", 30);
        ConsumInfosSerializable.start(cons1);
        ConsumInfosSerializable.start(cons2);
    }
    //注册网虫套餐场景
    public static void regNet(String cardNumber){
        ConsumInfo cons1 = new ConsumInfo(cardNumber, "流量", 3*1024);
        ConsumInfosSerializable.start(cons1);
    }
    //注册超人套餐场景
    public static void regSuper(String cardNumber){
        ConsumInfo cons1 = new ConsumInfo(cardNumber, "通话", 200);
        ConsumInfo cons2 = new ConsumInfo(cardNumber, "短信", 50);
        ConsumInfo cons3 = new ConsumInfo(cardNumber, "流量", 1*1024);
        ConsumInfosSerializable.start(cons1);
        ConsumInfosSerializable.start(cons2);
        ConsumInfosSerializable.start(cons3);
    }
}

