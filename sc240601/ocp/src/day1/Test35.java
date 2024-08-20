package day1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/19 20:26
 **/
public class Test35 {
    public static void main(String[] args) {
        var symbols = List.of("USD", "GBP", "EUR", "CNY");
        var exchangeRate = List.of(1.0, 1.3255, 1.1969, 0.1558094);
        var mapl = IntStream//整形数据流(里面只存放整数)
                .range(0,4)//获取0-3的范围 存储到整形中
                .boxed()//只是用于做类型转换(IntStream -> Stream)
                .collect(Collectors.toMap(
                        i->symbols.get(i),
                        i->1.0/exchangeRate.get(i)));//收集器方法
        System.out.println(mapl);
    }
}
