package doudou5G;

import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/7 17:01
 **/
public class Test {
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,6,7,8};
        System.out.println(find(a,6));
    }
    public static int find(int[] nums,int number){
        int first=0;
        int end = nums.length-1;
        while (first<=end){
            int min = (first+end)/2;
            if (number<nums[min]){
                end = min-1;
            }else if (number>nums[min]){
                first = min+1;
            }else {
                return min;
            }
        }
        return -1;
    }
}

