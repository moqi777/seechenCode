package doudou5G.util;

import doudou5G.entity.NetPackage;
import doudou5G.entity.SuperPackage;
import doudou5G.entity.TalkPackage;
import doudou5G.server.Index;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:变更套餐，修改文件中对应的用户信息
 * 参数：需要修改成哪个套餐 1：话痨 2：网虫 3：超人
 * @DateTime:2024/7/6 14:19
 **/
public class UpdatePackage {
    //直接修改NowcardNumber，然后将NowcardNumber存入文件
    public static boolean update(int serPackageId){
        //获取当前用户余额
        double d = Index.nowMobileCard.getMoney() - Index.nowMobileCard.getConsumAmount();
        //判断余额够不够扣除新的套餐费用
        //如果够用，修改所使用套餐，添加已消费话费，添加对应套餐余量（这里与PPT有一点出入，这里上次套餐余量不清空，有结余，累加余量）
        switch (serPackageId){
            case 1:
                if (d<58)return false;
                Index.nowMobileCard.setSerPackage(new TalkPackage(58,500,30));//修改套餐
                Index.nowMobileCard.setConsumAmount(Index.nowMobileCard.getConsumAmount()+58);//添加已消费话费
                Index.nowMobileCard.setRealTalkTime(Index.nowMobileCard.getRealTalkTime()+500);//加通话时长
                Index.nowMobileCard.setRealSMSCount(Index.nowMobileCard.getRealSMSCount()+30);//加短信数
                RegFirstScene.regTalk(Index.nowMobileCard.getCardNumber());//添加消费记录
                break;
            case 2:
                if (d<68)return false;
                Index.nowMobileCard.setSerPackage(new NetPackage(68,3*1024));//修改套餐
                Index.nowMobileCard.setConsumAmount(Index.nowMobileCard.getConsumAmount()+68);//添加已消费话费
                Index.nowMobileCard.setRealFlow(Index.nowMobileCard.getRealFlow()+3*1024);//加流量
                RegFirstScene.regNet(Index.nowMobileCard.getCardNumber());//添加消费记录
                break;
            case 3:
                if (d<78)return false;
                Index.nowMobileCard.setSerPackage(new SuperPackage(78,200,50,1*1024));//修改套餐
                Index.nowMobileCard.setConsumAmount(Index.nowMobileCard.getConsumAmount()+78);//添加已消费话费
                Index.nowMobileCard.setRealTalkTime(Index.nowMobileCard.getRealTalkTime()+200);//加通话时长
                Index.nowMobileCard.setRealSMSCount(Index.nowMobileCard.getRealSMSCount()+50);//加短信数
                Index.nowMobileCard.setRealFlow(Index.nowMobileCard.getRealFlow()+1*1024);//加流量
                RegFirstScene.regSuper(Index.nowMobileCard.getCardNumber());//添加消费记录
        }
        //将新的用户信息持久化
        RegSerializable.start(Index.nowMobileCard);
        return true;
    }
}
