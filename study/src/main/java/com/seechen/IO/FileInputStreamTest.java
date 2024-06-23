package com.seechen.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:fileInputStream经典案例
 * @DateTime:2024/6/24 1:13
 **/
public class FileInputStreamTest {
    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            fis=new FileInputStream("a.txt");
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len=fis.read(bytes))!=-1){
                System.out.print(new String(bytes,0,len));
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

