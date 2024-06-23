package com.seechen.Collection;

import java.util.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试链表实现
 * @DateTime:2024/6/22 14:17
 **/
public class TestLinkedList {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(10);
        list.add(5);
        list.add(15);
        for (int i = 0; i < list.size(); i++) {
            Integer n = list.get(i);
            System.out.println(n);
        }

        System.out.println("==========");
        privateMethond();
        System.out.println("===========");
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(100);
        list2.add(100);
        list2.add(200);
        list2.add(null);
        list2.add(null);
        list2.add(100);
        System.out.println(distinct(list2));
        System.out.println(distinct2(list2));
    }

    public static void privateMethond(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        List<Integer> list2 = new LinkedList<>();
        list2.add(10);
        list2.add(50);
        list2.add(100);
        LinkedList<Integer> list3 = (LinkedList<Integer>)list2;
        list3.addFirst(88);
        list3.addLast(300);
        Iterator<Integer> it = list3.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }

    //定义一个list集合 里面有很多重复的元素，编写一个方法实现集合里面的元素去重？
    public static List<Integer> distinct(List<Integer> list){
        ArrayList<Integer> newList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (!newList.contains(list.get(i))) newList.add(list.get(i));
        }
        return newList;
    }

    public static List<Integer> distinct2(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
        return new ArrayList<>(set);
    }
}

