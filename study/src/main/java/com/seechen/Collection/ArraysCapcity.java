package com.seechen.Collection;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:定义长度可变的数组 ArrayList<Intager>
 * @DateTime:2024/6/22 9:19
 **/
public class ArraysCapcity {
    //定义一个数组 默认长度10
    Object[] obj = new Object[10];
    //记录数组存储的下标
    int index;
    //向数组存值的方法（存储到11个时 触发扩容）
    public void add(Object o){
        if(index==obj.length)capcity();
        obj[index] = o;
        index++;
    }
    //数组扩容的方法   扩容1.5
    public void capcity(){
        //int = double
        int length = (int)(obj.length*1.5);
        //利用数组工具类 创建更长的数组 复制原数组的元素
        obj=Arrays.copyOf(obj,length);
//        Object[] obj2 = new Object[length];
//        for (int i = 0; i < obj.length; i++) {
//            obj2[i] = obj[1];
//        }
//        obj = obj2;
        System.out.println("扩容成功，数组新长度："+obj.length);
    }

    public static void main(String[] args) {
        ArraysCapcity array = new ArraysCapcity();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入数组的元素：输入esc退出");
            String content = scanner.next();
            if("esc".equals(content)) break;
            array.add(content);//底层会帮我们动态扩容
        }
        System.out.println("存储结束：");
        System.out.println(Arrays.toString(array.obj));
    }
}

