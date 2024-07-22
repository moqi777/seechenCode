package doudou5G.util;

import doudou5G.entity.ConsumInfo;
import doudou5G.entity.MobileCard;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:打电话、发短信、上网的公共实现方法
 * 参数：封装好的消费记录，其中包含电话号码，哪种操作类型，使用量
 * 返回：是否成功 boolean
 * @DateTime:2024/7/6 9:17
 **/
public class ServicePackageFuntion {
    //提示：此处代码本来是打电话的单独功能方法，现抽离出不同点实现公共方法，注释中标明了4点
    public static boolean start(ConsumInfo consumInfo){
        //创建一条消费记录
        //ConsumInfo consumInfo = new ConsumInfo(cardNumber, "通话", -90);
        //查询该用户是否存在（从文件中查找该用户）
        MobileCard mobileCard = SelectMobileCardToCardNumber.select((String) consumInfo.getCardNumber());
        if (mobileCard==null) {
            System.out.println("无效号码！！！");
            return false;
        }
        //判断该用户套餐余量（话费）是否够
        //用户剩余通话时长减去此次需要的通话时长，大于0 说明足够，就允许，num：剩余套餐量
        //1、公共方法与单独方法不同点：判断mobileCard的get哪种操作mobileCard.getXXX()
        int num = -1;
        switch (consumInfo.getType()){
            case "通话":num =(mobileCard.getRealTalkTime()+consumInfo.getConsumData());break;
            case "短信":num =(mobileCard.getRealSMSCount()+consumInfo.getConsumData());break;
            case "流量":num =(mobileCard.getRealFlow()+consumInfo.getConsumData());
        }
        if (num>=0){
            //若余量够，扣除余量。在此将num赋值给MobileCard的realTalkTime(剩余通话时长)变量
            //2、公共方法与单独方法不同点：判断是设置哪个套餐
            switch (consumInfo.getType()){
                case "通话":mobileCard.setRealTalkTime(num);break;
                case "短信":mobileCard.setRealSMSCount(num);break;
                case "流量":mobileCard.setRealFlow(num);
            }
        }else {//若余量不够，判断超出余量部分所需话费余额是否够
            //此处的num为还剩多少未处理的通话时长的负数
            //计算这些时长所需的话费
            //3、公共方法与单独方法不同点：根据不同类型计算不同套餐价格所需话费
            double d = 0;
            switch (consumInfo.getType()){
                case "通话":d = num*-0.2;break;
                case "短信":d = num*-0.1;break;
                case "流量":d = num*-0.1;
            }
            //计算用户剩余话费
            double d2 = mobileCard.getMoney()-mobileCard.getConsumAmount();
            //话费不够，停止操作并返回
            if (d2<d){
                System.out.println("您的账户余额不足以此次操作，请充值后再试");
                return false;
            }else {//话费够此次操作，扣除响应话费，将对应余量清零
                mobileCard.setConsumAmount(mobileCard.getConsumAmount()+d);
                //4、公共方法与单独方法不同点：判断将哪种类型的套餐清空
                switch (consumInfo.getType()){
                    case "通话":mobileCard.setRealTalkTime(0);break;
                    case "短信":mobileCard.setRealSMSCount(0);break;
                    case "流量":mobileCard.setRealFlow(0);
                }
                //提示用户此次操作扣除了多少话费
                System.out.println("提示：此次操作因通话时长余量不足，额外扣除了"+d+"元话费，请注意您的话费余额");
            }
        }
        //提示成功
        System.out.println("操作成功");
        //将新的mobileCard持久化
        RegSerializable.start(mobileCard);
        //将消费记录持久化
        //ConsumInfosSerializable.start(consumInfo);
        return true;
    }
}

