package day2;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/21 20:26
 **/
public class Test85 {
    public static void main(String[] args) {
        var fruits = List.of("b","o","a","l");
        var s1 = fruits.stream();
        var s2 = s1.peek(i-> System.out.println(i+" "));
        System.out.println("-------");
        var s3 = s2.sorted();
        var s4 = s3.peek(i-> System.out.println(i+""));
        System.out.println("-------");
        s4.collect(Collectors.joining(","));
        //数据流有三个生命周期分三个阶段
        //1.起始阶段：就是流生成的阶段   list.stream()
        //2.中间操作：会逐一对流的元素进行处理 可有可无的 但是所有中间操作
        //都是有惰性的(懒 延迟加载) 只有流真正使用的时候才会一口气执行中间操作
        //peek()    filter()    mapToInt()  flatMap()...
        //3.终端操作：属于流真正使用的阶段 作用就是用来启动流的运行 那么所有的中间操作才会真正执行
        //forEach() collect()
    }
}
