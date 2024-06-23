package com.seechen.Collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/22 17:15
 **/
public class TestMap {
    public static void main(String[] args) {
        test1();
    }
    public static void test1(){
        //key类型是String value类型是对象
        Map<String,Card> map=new HashMap<>();
        //Map<String, List<Integer[]>>
        map.put("555",new Card("♣5",5));
        map.put("666",new Card("♥6",5));
        map.put("777",new Card("♣8",6));
        map.put("888",new Card("♥5",5));
        map.put("999",new Card("♣5",8));
        Card c = map.get("666");
        System.out.println("迭代器");
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()){
            System.out.println(map.get(it.next()));
        }
        System.out.println("增强for");
        for (String s : map.keySet()) {
            System.out.println(map.get(s));
        }
    }
    public static void test2(){

    }
}

