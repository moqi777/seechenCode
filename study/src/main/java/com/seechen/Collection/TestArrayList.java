package com.seechen.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试ArrayList
 * @DateTime:2024/6/22 11:01
 **/
public class TestArrayList {
    public static void main(String[] args) {
        //List 名称=new 实现类（）；
        List list = new ArrayList();
        list.add(10);
        list.add("java");
        list.add(true);
        list.add('+');
        list.add(new Object());
        list.add(3,100.1);
        System.out.println("集合遍历方式1：标准for");
        for (int i = 0; i < list.size(); i++) {
            if(i==3){
                double d = (double)list.get(i);
                double price = 10;
                System.out.println(d*price);
            }
            Object o = list.get(i);
            System.out.println(o);
        }
        System.out.println("集合遍历方式2：增强for");
        //for(数据类型 临时变量(每次循环出来集合元素)：集合或者数组){}
        for(Object o:list){
            System.out.println(o);
        }
        System.out.println("集合遍历方式3：迭代器");
        //将集合的元素 临时放入数据序列（迭代器）
        Iterator it = list.iterator();
        //it.next   每次获取第一个元素 再删除第一个
        //it.hasNext()  迭代器专门判断是否有下一个
        while (it.hasNext()){
            Object o = it.next();
            System.out.println(o);
        }

        testGenericity();
    }

    //测试泛型
    public static void testGenericity(){
        List<Integer> list=new ArrayList<>();
        list.add(10);
        list.add(20);
        //list.add(15.50);泛型强制要求了只能放Intager
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("mysql");
        list2.add("java");

        for (int i = 0; i < list.size(); i++) {
            Integer n = list.get(i);
            System.out.println(n);
        }
        for (String s : list2) {
            System.out.println(s);
        }
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            Integer i = it.next();
            System.out.println(i);
        }
    }
}

