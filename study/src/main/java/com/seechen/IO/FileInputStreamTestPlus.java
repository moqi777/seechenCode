package com.seechen.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:使用available获取字节数，无需while
 * @DateTime:2024/6/24 1:34
 **/
public class FileInputStreamTestPlus {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("a.txt");
            int size = fis.available();
            byte[] bytes = new byte[size];
            fis.read(bytes);
            System.out.println(new String(bytes));
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

