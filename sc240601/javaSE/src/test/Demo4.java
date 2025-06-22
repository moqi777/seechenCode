package test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/10/11 19:23
 **/
import java.util.Scanner;
public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int sum = scanner.nextInt();
            int totalXor = 0;
            for (int j = 1; j <= n; j++) {
                totalXor ^= j;
            }
            int missingNumber = totalXor ^ sum;
            System.out.println(missingNumber);
        }
        scanner.close();
    }
}
