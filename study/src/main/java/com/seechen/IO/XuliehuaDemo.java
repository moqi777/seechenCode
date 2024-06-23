package com.seechen.IO;

import java.io.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/23 15:57
 **/
public class XuliehuaDemo {
    public static void main(String[] args) {
        read();
    }

    public static void write(){
        try (FileOutputStream fos = new FileOutputStream("str.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            String[] strings = {"你好","我有一个毛衫","我想在网上问问"};
            oos.writeObject(strings);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void read(){
        try (FileInputStream fis = new FileInputStream("str.txt");
        ObjectInputStream ois = new ObjectInputStream(fis)){
            String[] strings = (String[]) ois.readObject();
            for (String string : strings) {
                System.out.print(string);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

