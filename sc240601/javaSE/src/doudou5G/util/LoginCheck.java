package doudou5G.util;

import doudou5G.entity.MobileCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:用于登录验证
 * @DateTime:2024/7/4 18:38
 **/
public class LoginCheck {
    public static MobileCard check(String cardNumber,String password){
        List<MobileCard> mobileCards = SelectMobileCards.select();
        for (MobileCard mobileCard : mobileCards) {
            HashMap<String, Object> map = mobileCard.showMeg();
            //如果找到了这个用户
            if (cardNumber.equals(((String)map.get("cardNumber")))) {
                //验证密码
                if (password.equals(((String) map.get("password")))) {
                    //如果用户密码不相等
                    return mobileCard;
                }
                System.out.println("密码错误，请重新登录！！！");
                return null;
            }
        }
        System.out.println("该用户不存在，请注册！！！");
        return null;
    }
}

