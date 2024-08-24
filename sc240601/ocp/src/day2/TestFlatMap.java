package day2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/21 20:00
 **/
public class TestFlatMap {
    public static void main(String[] args) {
        //flatMap() 是流中的 用于实现 维度升降的方法
        var a = List.of("a","b","c");
        var b=List.of("e","f","g");
        //降维
        var s = Stream.of(a, b);//一维
        var s2 = s.flatMap(c -> c.stream())
                .collect(Collectors.toList());//二维
        s2.forEach(x-> System.out.println(x));

        //升维
        var num1 = List.of(1,2,3);//一维
        var num2 = List.of(9,10);
        var num3 = num1.stream()
                .flatMap(x -> num2.stream()
                .map(y -> new Integer[]{x, y}));//二维
    }
}
