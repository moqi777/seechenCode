package com.seechen.IO;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:字节拷贝案例
 * @DateTime:2024/6/24 1:43
 **/
public class StreamCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream("a.txt");
            fos = new FileOutputStream("b.txt",true);
            byte[] bytes = new byte[fis.available()];
            fis.read(bytes);
            fos.write(bytes);
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

