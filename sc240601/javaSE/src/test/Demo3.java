package test;



/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:趣拿笔试第三题
 * @DateTime:2024/10/10 15:06
 **/
import java.util.Scanner;
public class Demo3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取n和m，分别是车站数量和要查询的最大坐车时间
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 初始化车站间的距离矩阵
        int[][] distance = new int[n][n];

        // 读取车站之间的距离
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = scanner.nextInt();
            }
        }

        // 使用Floyd-Warshall算法计算每两个车站之间的最短路径
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // 如果i到k和k到j都不是-1，则计算最短路径
                    if (distance[i][k] != -1 && distance[k][j] != -1) {
                        if (distance[i][j] == -1 || distance[i][j] > distance[i][k] + distance[k][j]) {
                            distance[i][j] = distance[i][k] + distance[k][j];
                        }
                    }
                }
            }
        }

        // 输出结果
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int fatigue = distance[i][j];
                if (fatigue == -1) {
                    System.out.print("-1 ");
                } else {
                    System.out.print(fatigue + " ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}
