package day2;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/21 19:50
 **/
public class Test64 {
    public static void main(String[] args) {
        var list = List.of("a","c","b");
        //通过集合将元素存储到串行流中
        // list.stream()
        //如果想过去并行流
        //1.可以通过集合直接获取
        // list.parallelStream();
        //2.可以通过串行流转换成并行流
        // list.stream().parallel();

        var numbers = List.of(1,2,3,4,5);
        int sum = numbers.stream()
                //累加函数(参数1：累加的初值，参数2：累加规则) n=n+m
                .reduce(0, (n, m) -> n + m);
        System.out.println(sum);
    }
}
