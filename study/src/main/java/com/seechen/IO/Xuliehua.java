package com.seechen.IO;

import java.io.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/23 15:37
 **/
public class Xuliehua {
    public static void main(String[] args) {
        //序列化的类必须实现序列化接口java.io.Serializable
        //必须生成序列化ID，序列化id是一个标识，标识版本
        //1.创建需要序列化的对象
        String str = "你好111";
        //2.创建流
        FileOutputStream fos = null;
        //创建序列化的流
        ObjectOutputStream oos = null;
        try {
            fos=new FileOutputStream(new File("str.txt"));
            oos = new ObjectOutputStream(fos);
            //使用流
            //将对象写入文件中，跟写字符串没区别，只是看不懂这个字符串
            oos.writeObject(str);
            //4.关闭流
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

