package test;

import java.util.Scanner;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:趣拿笔试第一题
 * @DateTime:2024/10/10 14:39
 **/
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int l = sc.nextInt();
        int r = sc.nextInt();
        for (int i = l; i <= r; i++) {
            if (isBingo(i, k)) {
                System.out.println(i);
            }
        }
    }
    public static boolean isBingo(int num, int k) {
        if (num % k == 0) {
            return true;
        }
        String numStr = String.valueOf(num);
        String kStr = String.valueOf(k);
        return numStr.contains(kStr);
    }
}
