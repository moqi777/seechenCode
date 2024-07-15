package day9;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:递归实现斐波那契数列
 * @DateTime:2024/7/14 20:06
 **/
public class FeiBoNaQie {
    public static void main(String[] args) {
        for (int i = 1; i <= 20; i++) {
            System.out.println(fei(i));
        }
    }
    public static int fei(int n){
        if (n==1||n==2) return 1;
        return fei(n-1)+fei(n-2);
    }
}

