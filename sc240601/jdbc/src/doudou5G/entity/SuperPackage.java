package doudou5G.entity;
import doudou5G.Service.Interface.CallService;
import doudou5G.Service.Interface.NetService;
import doudou5G.Service.Interface.SendService;
import doudou5G.util.ConsumInfosSerializable;
import doudou5G.util.ServicePackageFuntion;

import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:超人套餐实体类
 * @DateTime:2024/7/4 13:57
 **/
public class SuperPackage extends ServicePackage implements CallService, SendService, NetService {
    private int talkTime;//套餐包含的通话时长
    private int smsCount;//套餐包含的短信数
    private int flow;//套餐包含的流量

    public HashMap<String, Object> showInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("talkTime",talkTime);
        map.put("smsCount",smsCount);
        map.put("flow",flow);
        map.put("price",super.price);
        return map;
    }

    public SuperPackage() {
    }

    public SuperPackage(double price, int talkTime, int smsCount, int flow) {
        super(price);
        this.talkTime = talkTime;
        this.smsCount = smsCount;
        this.flow = flow;
    }

    @Override
    public boolean call(int minCount, String cardNumber) {
        ConsumInfo consumInfo = new ConsumInfo(cardNumber, "通话", minCount);
        boolean isOk;
        if (isOk = ServicePackageFuntion.start(consumInfo)){
            ConsumInfosSerializable.start(consumInfo);
        }
        return isOk;
    }

    @Override
    public boolean netPlay(int flow, String cardNumber) {
        ConsumInfo consumInfo = new ConsumInfo(cardNumber, "流量", flow);
        boolean isOk;
        if (isOk = ServicePackageFuntion.start(consumInfo)){
            ConsumInfosSerializable.start(consumInfo);
        }
        return isOk;
    }

    @Override
    public boolean send(int count, String cardNumber) {
        ConsumInfo consumInfo = new ConsumInfo(cardNumber, "短信", count);
        boolean isOk;
        if (isOk = ServicePackageFuntion.start(consumInfo)){
            ConsumInfosSerializable.start(consumInfo);
        }
        return isOk;
    }
}

