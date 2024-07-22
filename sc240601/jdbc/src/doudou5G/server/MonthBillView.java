package doudou5G.server;

import doudou5G.entity.ServicePackage;

import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:本月账单查询
 * @DateTime:2024/7/4 23:24
 **/
public class MonthBillView {
    public MonthBillView() {
        System.out.println("\n*****本月账单查询*****");
        HashMap<String, Object> map = Index.nowMobileCard.showMeg();
        System.out.println("您的卡号："+map.get("cardNumber")+"，当月账单：");
        System.out.println("套餐资费："+((ServicePackage)map.get("serPackage")).showInfo().get("price")+"元");
        //如果更改了套餐，之前的套餐资费也会算在套餐外消费当中，套餐资费只会输出当前所使用的套餐资费
        System.out.println("套餐外消费："+(Index.nowMobileCard.getConsumAmount()-(double)(Index.nowMobileCard.getSerPackage().showInfo().get("price")))+"元");
        System.out.println("合计："+map.get("consumAmount")+"元");
        System.out.println("账户余额："+((double)map.get("money")-(double)map.get("consumAmount"))+"元");
    }
}

