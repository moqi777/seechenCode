package test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:趣拿笔试第二题
 * @DateTime:2024/10/10 14:45
 **/
import java.util.*;

public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取n和q
        int n = scanner.nextInt();
        int q = scanner.nextInt();

        // 读取初始字符串
        String s = scanner.next();
        StringBuilder sb = new StringBuilder(s);

        // 创建一个boolean数组来记录哪些位置是固定的
        boolean[] fixed = new boolean[n];

        // 执行q次操作
        for (int i = 0; i < q; i++) {
            int op = scanner.nextInt();
            int u = scanner.nextInt() - 1; // 转换为0索引

            if (op == 1) {
                // 操作1：将第u个位置变为固定位置
                fixed[u] = true;
            } else if (op == 2) {
                // 操作2：流动位置的字符向右循环移动
                // 找出所有流动的位置
                List<Integer> movableIndices = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    if (!fixed[j]) {
                        movableIndices.add(j);
                    }
                }

                if (movableIndices.size() > 0) {
                    // 保存最后一个位置的字符
                    char lastChar = sb.charAt(movableIndices.get(movableIndices.size() - 1));
                    // 其余字符依次往后移动
                    for (int j = movableIndices.size() - 1; j > 0; j--) {
                        sb.setCharAt(movableIndices.get(j), sb.charAt(movableIndices.get(j - 1)));
                    }
                    // 将最后一个字符放到第一个流动位置上
                    sb.setCharAt(movableIndices.get(0), lastChar);
                }
            }
        }

        // 输出最终结果
        System.out.println(sb.toString());
    }
}
