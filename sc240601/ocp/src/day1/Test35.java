package day1;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

        var map2 = mapl.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey()) //对流中的entry元素进行排序
                .collect(Collectors.toMap(
                        Map.Entry::getKey,//借助与Entry类的getKey 获取流中的Key元素
                        Map.Entry::getValue,
                        //是用于防止值(key和value)重复的，如果值存在了 使用老的值
                        (oldValue,newValue)->oldValue,
                        LinkedHashMap::new//借助于new LinkedHashMap 构建最终的集合
                ));
        System.out.println(map2);
        map2.forEach((var k,var v)->
                //参数1：打印规则 参数2：k的值 参数3：v的值
                //%s表示k的打印规则 通过字符串打印
                //%.2f表示v的打印规则 通过浮点型 保留2位
                //\n 每打印一组key和value换行
                System.out.printf("%s->%.2f\n",k,v));
    }
}
