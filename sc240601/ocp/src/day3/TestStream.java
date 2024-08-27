package day3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/26 19:14
 **/
public class TestStream {
    public static void main(String[] args) {
        var list = List.of(1,2,3,4,5,6,7);
        //创建串行流
        var s1 = list.stream();
        //创建并行流：1.直接创建 2.串行转换
        var s2 = list.parallelStream();
        var s3 = list.stream().parallel();
        System.out.println("串行流打印：");
        s1.forEach(x-> System.out.println(x));
        System.out.println("并行流打印：");
        s2.forEach(x-> System.out.println(x));
        System.out.println("并行流打印：");
        s3.forEach(x-> System.out.println(x));
        System.out.println("=================================");
        System.out.println("存储100以内的偶数");
        Stream.iterate(1,x->x+1)
                .limit(99)
                .filter(x->x%2==0)
                .forEach(x-> System.out.println(x));
        System.out.println("====================================");
        int[] nums = {10,5,6,4,6,7};
        var s5 = Arrays.stream(nums);
        var s6 = s5.boxed();
        System.out.println("=====================================");
        //bug：不能存储null 空指针异常
        var s7 = Stream.of("aa","bb","cc");
        // var s8 = Stream.of(null);
        System.out.println("=====================================");
        var s9 = Stream.of(1,3,2,5,6,7);
        //获取判断为真的元素 但是一旦出现假的元素 就结束判断后面都不执行了
        var s10 = s9.takeWhile(x->x%2 != 0);
        s10.forEach(x-> System.out.print(x+" "));//1 3
        System.out.println("\n======================================");
        var s11 = Stream.of(1,7,4,1,4,6);
        //丢弃判断为真的元素 但是一旦为假的元素 就结束判断 后面的元素都要了
        var s12 = s11.dropWhile(x->x%2!=0);
        s12.forEach(x-> System.out.println(x+" "));//4 1 4 6
    }
}
