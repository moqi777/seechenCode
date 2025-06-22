package test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/10/11 19:35
 **/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Demo5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int x = scanner.nextInt();
        String baseX = Long.toString(n, x);
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : baseX.toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }
        char maxDigit = '0';
        int maxCount = 0;
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char digit = entry.getKey();
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && digit > maxDigit)) {
                maxDigit = digit;
                maxCount = count;
            }
        }
        System.out.println(maxDigit);
    }
}
