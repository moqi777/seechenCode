package com.seechen.IO;

import java.io.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:使用缓冲区(增强流)案例
 * @DateTime:2024/6/24 2:03
 **/
public class BufferedCopy {
    public static void main(String[] args) {
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        try {
            fis = new FileInputStream("背景.jpg");
            bis = new BufferedInputStream(fis);
            fos = new FileOutputStream("背景-副本.jpg");
            bos = new BufferedOutputStream(fos);
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = bis.read(bytes))!=-1){
                bos.write(bytes);
            }
            bis.close();
            bos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

