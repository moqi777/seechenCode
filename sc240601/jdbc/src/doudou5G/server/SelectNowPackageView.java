package doudou5G.server;

import doudou5G.entity.NetPackage;
import doudou5G.entity.ServicePackage;
import doudou5G.entity.SuperPackage;
import doudou5G.entity.TalkPackage;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:查看当前套餐
 * @DateTime:2024/7/6 13:51
 **/
public class SelectNowPackageView {
    public SelectNowPackageView() {
        System.out.println("\n*****您当前套餐为*****");
        ServicePackage serPackage = Index.nowMobileCard.getSerPackage();
        if (serPackage instanceof TalkPackage) System.out.println("话痨套餐");
        if (serPackage instanceof NetPackage) System.out.println("网虫套餐");
        if (serPackage instanceof SuperPackage) System.out.println("超人套餐");
    }
}

