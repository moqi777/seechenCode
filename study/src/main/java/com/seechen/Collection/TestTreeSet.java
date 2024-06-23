package com.seechen.Collection;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/22 15:48
 **/
public class TestTreeSet {
    public static void main(String[] args) {
        test4();
    }
    public static void test1(){
        Set<Integer> set = new TreeSet<>();
        set.add(100);
        set.add(50);
        set.add(30);
        set.add(50);
        set.add(11);
        //默认支持基本类型自然排序：升序
        System.out.println(set);
    }
    public static void test2(){
        Set<String> set = new TreeSet<>();
        set.add("aaa");
        set.add("aaa");
        set.add("111");
        set.add("111");
        set.add("Aaa");
        set.add("a");
        set.add("1");
        set.add("9");
        //默认支持String类型自然排序：按位比较ASCII
        System.out.println(set);
    }
    //测试内部比较器
    public static void test3(){
        Set<Card> set = new TreeSet<>();
        set.add(new Card("♥J",11));
        set.add(new Card("♠J",11));
        set.add(new Card("♣J",11));
        set.add(new Card("♥2",15));
        set.add(new Card("♦2",15));
        System.out.println(set);
    }
    //测试外部比较器：单独设计一个类
    //匿名内部类 lombda表达式
    public static void test4(){
        Comparator<Card> com = new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                int result = o1.num-o2.num;
                if(result==0) result = o1.str.compareTo(o2.str);
                return result;
            }
        };
        Comparator<Card> com2 = (o1,o2)->{
            int result = o1.num-o2.num;
            if(result==0) result = o1.str.compareTo(o2.str);
            return result;
        };
        Set<Card> set = new TreeSet<>(new Com());
        set.add(new Card("♥J",11));
        set.add(new Card("♠J",11));
        set.add(new Card("♣J",11));
        set.add(new Card("♥2",15));
        set.add(new Card("♦2",15));
        System.out.println(set);
    }
}
//牌类 ：模拟洗牌后的排序功能♥J ♠A ♦2 ♣10
//class Card implements Comparable<Card>{
//    String str;//存储花色
//    int num;//表示数字
//
//    public Card(String str, int num) {
//        this.str = str;
//        this.num = num;
//    }
//
//    //toString()    对象打印默认是打印地址
//    //重写了toString() 它返回什么 打印对象就会打印什么
//    public String toString() {
//        return str;
//    }
//
//    //内部比较器实现排序规则的方法
//    //规则：this和o对象比较
//    public int compareTo(Card o) {
//        //先比较数值
//        int result = o.num-this.num;
//        //如果数值相同 比较花色
//        if(result==0) result = o.str.compareTo(this.str);
//        return result;
//    }
//}

class Card{
    String str;//存储花色
    int num;//表示数字

    public Card(String str, int num) {
        this.str = str;
        this.num = num;
    }

    public String toString() {
        return str;
    }
}
//单独设计一个类
class Com implements Comparator<Card>{
    public int compare(Card o1, Card o2) {
        int result = o1.num-o2.num;
        if(result==0) result = o1.str.compareTo(o2.str);
        return result;
    }
}
