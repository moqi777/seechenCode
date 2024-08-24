package day2;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/21 19:32
 **/
public class TestList {
    public static void main(String[] args) {
        var list = List.of(10, 20, 30, 40, 50);
        System.out.println(list.get(2));
        for(Integer i:list){
            System.out.println(i);
        }
        list.forEach(a-> System.out.println(a));

        list.add(100);
        list.remove(3);
        //java10 添加新的方法 copyOf()
        var list2 = List.copyOf(list);
    }
}
