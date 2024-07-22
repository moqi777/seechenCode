package doudou5G.util;

import doudou5G.entity.ServicePackage;
import doudou5G.server.Index;

import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:用于在注册中对用户充值的话费进行验证
 * @DateTime:2024/7/4 16:24
 **/
public class RegMoneyYH {
    //参数：用户选择的套餐
    //返回：用户充值的金额
    public static double verify(ServicePackage serPackage){
        HashMap<String, Object> map = serPackage.showInfo();
        while (true){
            System.out.print("请输入预存话费金额(仅支持10-9999元整数)：");
            String moneyStr = Index.scanner.next();
            double money = ScannerYN.verify(moneyStr, 10, 9999);
            //输入错误重新输入
            if (money==-1) {
                continue;
            }else if (money<(double)map.get("price")){
                System.out.println("您预存的话费金额不足以支付本月固定套餐资费！！！");
            }else {
                return money;
            }
        }
    }
}

