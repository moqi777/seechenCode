package doudou5G.server;

import doudou5G.entity.NetPackage;
import doudou5G.entity.ServicePackage;
import doudou5G.entity.SuperPackage;
import doudou5G.entity.TalkPackage;
import doudou5G.util.ScannerYN;
import doudou5G.util.UpdatePackage;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:套餐变更
 * @DateTime:2024/7/6 13:16
 **/
public class UpdatePackageView {
    public UpdatePackageView() {
        System.out.println("\n*****套餐变更*****");
        System.out.print("1.话痨套餐 2.网虫套餐 3.超人套餐 请选择(序号)：");
        String next = Index.scanner.next();
        //对用户输入进行有效性验证
        int verify = ScannerYN.verify(next, 1, 3);
        if (verify==-1) return;
        //验证是否是当前套餐，并根据用户输入选择变更套餐
        ServicePackage serPackage = Index.nowMobileCard.getSerPackage();
        boolean b = false;
        double packageUser = 0;
        switch (verify){
            case 1:
                if (serPackage instanceof TalkPackage){
                    System.out.println("对不起，您已经是该套餐用户，无需换套餐！");
                    return;
                }
                b=UpdatePackage.update(1);
                packageUser = 58;
                break;
            case 2:
                if (serPackage instanceof NetPackage){
                    System.out.println("对不起，您已经是该套餐用户，无需换套餐！");
                    return;
                }
                b=UpdatePackage.update(2);
                packageUser = 68;
                break;
            case 3:
                if (serPackage instanceof SuperPackage){
                    System.out.println("对不起，您已经是该套餐用户，无需换套餐！");
                    return;
                }
                b=UpdatePackage.update(3);
                packageUser = 78;
        }
        if (!b){
            System.out.println("对不起，您的余额不足以支付新套餐本月资费，请充值后再办理更换套餐业务!");
        }else {
            double d = Index.nowMobileCard.getMoney() - Index.nowMobileCard.getConsumAmount(); //剩余话费
            System.out.println("套餐变更成功，扣除套餐相应资费费"+packageUser+"元，您账户剩余"+d+"元");
        }
    }
}

