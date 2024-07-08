package doudou5G.entity;

import doudou5G.Service.Interface.NetService;
import doudou5G.util.ConsumInfosSerializable;
import doudou5G.util.ServicePackageFuntion;

import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:网虫套餐实体类
 * @DateTime:2024/7/4 13:57
 **/
public class NetPackage extends ServicePackage implements NetService {
    private int flow;//套餐包含的流量，单位为兆

    public HashMap<String, Object> showInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("flow",flow);
        map.put("price",super.price);
        return map;
    }

    public NetPackage() {
    }

    public NetPackage(double price, int flow) {
        super(price);
        this.flow = flow;
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
}

