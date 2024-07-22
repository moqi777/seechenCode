package doudou5G.server;

import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:套餐余量查询
 * @DateTime:2024/7/4 23:46
 **/
public class RemainSerPackageView {
    public RemainSerPackageView() {
        System.out.println("\n*****套餐余量查询*****");
        HashMap<String, Object> map = Index.nowMobileCard.showMeg();
        System.out.println("您的卡号："+map.get("cardNumber")+"，套餐内剩余：");
        System.out.println("通话时长："+map.get("realTalkTime")+"分钟");
        System.out.println("短信条数："+map.get("realSMSCount")+"条");
        System.out.println("上网流量："+map.get("realFlow")+"MB");
    }
}

