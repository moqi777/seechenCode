package test;

public class Student {
    public static void main(String[] args) {
        int[] arr = {6, 3, 8, 2, 9, 1};

        // 冒泡排序算法
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // 交换两个数的位置
                    arr[j] = arr[j] ^ arr[j + 1];
                    arr[j + 1] = arr[j] ^ arr[j + 1];
                    arr[j] = arr[j] ^ arr[j + 1];
                }
            }
        }

        // 打印排序后的结果
        System.out.print("排序后的数组：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}

