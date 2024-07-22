package doudou5G.util;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:卡号生成工具类，直接打印出来，并把九个号码封装成数组返回
 * @DateTime:2024/7/4 14:32
 **/
public class CardNumberGen {
    public static String[] gen(){
        String[] cardNumbers = new String[9];
        //随机生成九个号码
        for (int i = 1; i < 10; i++) {
            int fist = 139;
            //随机生成两组四位数号码
            int middle = (int)(Math.random()*10000);
            int tail = (int)(Math.random()*10000);
            // 格式化成4位数，不足4位的在前面补0
            String middleStr = String.format("%04d", middle);
            String tailStr = String.format("%04d", tail);
            //拼接成号码
            String cardNumber = fist+middleStr+tailStr;

            //如果该号码重复，重新生成
            for (String number : cardNumbers) {
                if (cardNumber.equals(number)) i--;continue;
            }
            //查找已注册用户是否有重复的号码
            if (SelectMobileCardToCardNumber.select(cardNumber) != null){
                i--;
                continue;
            }

            System.out.print(i+"."+cardNumber+"    ");
            if (i%3==0) System.out.println();//每三个换行
            //存入数组
            cardNumbers[i-1]=cardNumber;
        }
        return cardNumbers;
    }
}

