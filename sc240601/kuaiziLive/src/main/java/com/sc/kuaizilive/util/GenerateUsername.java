package com.sc.kuaizilive.util;

import java.util.UUID;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/2 16:08
 **/
public class GenerateUsername {
    public static String getUsername(){
        // 获取当前时间的时间戳
        long timestamp = System.currentTimeMillis();

        // 生成一个UUID并获取它的前8位
        String uuidPart = UUID.randomUUID().toString().substring(0, 8);

        // 从UUID部分提取3位字母并转为大写
        String letters = uuidPart.replaceAll("[^a-zA-Z]", "");
        if (letters.length() < 3) {
            // 如果提取的字母不够3个，可以在这里处理，比如使用默认值或补充字母
            letters = String.format("%-3s", letters).replace(' ', 'A'); // 补充字母到3个
        } else {
            letters = letters.substring(0, 3);
        }
        letters = letters.toUpperCase(); // 转为大写

        // 从时间戳中提取6位数字
        String digits = String.valueOf(timestamp);
        if (digits.length() < 6) {
            // 如果时间戳不足6位，补充前导零
            digits = String.format("%06d", timestamp);
        } else {
            digits = digits.substring(7, 13);
        }

        // 组合成目标字符串
        String str = letters + digits;
        return str;
    }
}
