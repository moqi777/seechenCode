package com.seechen.Collection;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/22 15:28
 **/
public class TestHashSet {
    public static void main(String[] args) {
        //底层实现其实就是HashMap 哈希表
        Set<String> set = new HashSet<>();
        set.add("java");
        set.add("html");
        set.add("javascript");
        set.add("jQuery");
        set.add("java");
        //set集合无法单独获取一个值 没下标
        //只能通过迭代器 和增强for来实现
        for (String o : set) {
            System.out.println(o);
        }
        Iterator<String> it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}

