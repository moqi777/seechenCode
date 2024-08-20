package day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/19 19:55
 **/
public class Test14 {
    public static void main(String[] args) {
        var items = List.of(
          new Item("A",10),
          new Item("B",2),
          new Item("C",12),
          new Item("D",5),
          new Item("E",6)
        );
        double avg = items
                .stream()//将集合的5个对象放入数据流(串行流)中
                .mapToInt(i->i.amount)//类似于中间操作 把数据流的元素逐一获取出来转换int
                .average()//求平均值
                .orElse(0.0);//如果值存在返回这个值 不存在返回 0.0
        System.out.println(avg);//7.0
        Optional<Item> item = items
                .parallelStream()//将集合的元素放入数据流(并行流)中
                .filter(i->i.amount<avg)//过滤规则(小于7.0才保留)
                .findAny();//获取任意一个
        //打印item 如果没有值则抛出异常
        System.out.println(item.orElseThrow());
    }
}

class Item{
    public String name;
    public int amount;

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                '}';
    }

    public Item(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }
}