package designMode;

import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:选择排序
 * @DateTime:2024/7/18 10:01
 **/
public class XuanZhe {
    public static void main(String[] args) {
        int[] nums={7,9,3,6,8,4,0,3};
        for (int i = 0; i < nums.length - 1; i++) {
            int index = i;
            for (int j = i+1; j < nums.length; j++) {
                if (nums[index] > nums[j]){
                    index=j;
                }
            }
            if (i!=index){
                nums[i]=nums[i]^nums[index];
                nums[index]=nums[i]^nums[index];
                nums[i]=nums[i]^nums[index];
            }
        }
        System.out.println(Arrays.toString(nums));

        int one = Integer.MIN_VALUE;
        int two = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>one){//如果比最大值还大
                two = one;//先把原来的one赋给two
                one = nums[i];//把更大的值赋值给one
            }else if(nums[i]>two){//如果比最大的小但是比第二大的大
                two=nums[i];
            }
        }
        System.out.println(two);
    }
}

