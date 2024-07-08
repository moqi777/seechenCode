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
        int[] nums = {2,6,8,9,3,6,9,4,8};
        quick(nums,0,nums.length-1);
        System.out.println(Arrays.toString(nums));
    }
    public static void quick(int[] nums,int begin,int end){
        if (begin<end){//出口
            //1.计算基准数下标
            int index = getIndex(nums,begin,end);
            //2.对前半部分递归
            quick(nums,begin,index-1);
            //3.对数组后半部分递归
            quick(nums,index+1,end);
        }
    }
    public static int getIndex(int[] nums,int begin,int end){
        //设置基准数
        int temp = nums[begin];
        while (begin<end){
            while (begin<end && nums[end]>=temp) {
                //先从后往前比 如果大了 end-1
                end--;
            }
            //如果小了 将end下标 赋值给 begin下标的值
            nums[begin]=nums[end];
            while (begin<end && nums[begin]<=temp){
                //再从前往后比 如果小了 begin+1
                begin++;
            }
            //如果大了 将begin下标 赋值给end下标的值
            nums[end] = nums[begin];
        }
        //除了while循环 说明begin和end相等了
        nums[end]=temp;
        return end;
    }

}

