package doudou5G.server;

import doudou5G.entity.ConsumInfo;
import doudou5G.util.ConsumInfosReSerializable;

import java.util.HashMap;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:打印消费清单
 * @DateTime:2024/7/5 11:45
 **/
public class PrintBuyBillView {
    public PrintBuyBillView() {
        String cardNumber = (String)Index.nowMobileCard.showMeg().get("cardNumber");
        System.out.println("\n*****"+cardNumber+"消费记录*****");
        System.out.println("序号     类型     数据(通话(条)/上网(MB)/短信(条))");
        //根据电话号码查询对应的消费清单
        List<ConsumInfo> consumInfos = ConsumInfosReSerializable.start(cardNumber);
        if (consumInfos==null) return;
        for (int i = 0; i < consumInfos.size(); i++) {
            HashMap<String, Object> map = consumInfos.get(i).showInfo();
            System.out.println((i+1)+"."+"       "+map.get("type")+"      "+((int)map.get("consumData")<0?map.get("consumData"):"+"+map.get("consumData")));
        }
    }
}

