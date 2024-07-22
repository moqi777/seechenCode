package doudou5G.util;

import doudou5G.entity.MobileCard;

import java.util.HashMap;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:根据一个电话号码查询一条用户信息
 * @DateTime:2024/7/4 17:44
 **/
public class SelectMobileCardToCardNumber {
    public static MobileCard select(String cardNumber){
        List<MobileCard> mobileCards = SelectMobileCards.select();
        for (MobileCard mobileCard : mobileCards) {
            HashMap<String, Object> map = mobileCard.showMeg();
            if (cardNumber.equals((String)map.get("cardNumber"))) return mobileCard;
        }
        return null;
    }
}

