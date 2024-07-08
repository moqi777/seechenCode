package doudou5G.server;

import doudou5G.entity.MobileCard;
import doudou5G.util.RegSerializable;
import doudou5G.util.ScannerYN;
import doudou5G.util.SelectMobileCardToCardNumber;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:话费充值
 * @DateTime:2024/7/6 15:31
 **/
public class TopUpView {
    public TopUpView() {
        System.out.print("请输入充值卡号：");
        String next = Index.scanner.next();
        MobileCard select = SelectMobileCardToCardNumber.select(next);
        if (select==null){
            System.out.println("错误输入或卡号不存在");
            return;
        }
        double money = 0;
        while (true){
            System.out.print("请输入充值金额(10-9999元整数)：");
            next = Index.scanner.next();
            money = ScannerYN.verify(next, 10, 9999);
            //输入错误重新输入
            if (money==-1){
                continue;
            }
            break;
        }
        //将钱存入
        select.setMoney(select.getMoney()+money);
        RegSerializable.start(select);
        System.out.println("充值成功，当前话费余额为"+select.getMoney()+"元。");
    }
}

