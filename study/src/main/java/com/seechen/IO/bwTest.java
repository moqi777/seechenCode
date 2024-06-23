package com.seechen.IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/23 14:46
 **/
public class bwTest {
    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bfw = null;
        try {
            fw = new FileWriter("a.txt");
            bfw = new BufferedWriter(fw);
            bfw.write("你好");
            bfw.write("helloWorld");
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

