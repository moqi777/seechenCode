package doudou5G.util;

import doudou5G.server.Index;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:验证用户输入密码
 * @DateTime:2024/7/4 15:57
 **/
public class RegPasswordYN {
    public static String verify(){
        for (int i = 2; i >= 0; i--) {
            System.out.print("请输入密码：");
            String password = Index.scanner.next();
            System.out.print("请输入确认密码：");
            String passwordTo = Index.scanner.next();
            if (!password.equals(passwordTo)){
                System.out.println("两次密码不一致(你还有"+i+"次机会)");
            }else {
                return password;
            }
        }
        System.out.println("注册失败！！！");
        return null;
    }
}

