package day7;

import java.io.*;
import java.util.Scanner;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/2 22:19
 **/

//模拟文件复制功能，手动输入文件地址   和目标地址
//  实现文件复制， 在控制台上显示“XXX文件已复制10%”，
//“XXX文件已复制20%”……“XXX文件已复制100%”，
//“XXX复制完成！”
public class Job3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入需要复制的文件地址");
        String formFilePath = scanner.next();
        System.out.println("请输入目标地址");
        String toFilePath = scanner.next();
        long first = System.currentTimeMillis();
        File file = new File(formFilePath);
        long fileLen = file.length();
        String name = null;
        if (file.exists()){
            name = file.getName();
            toFilePath += "\\"+name;
        }else {
            System.out.println("文件不存在");
            System.exit(0);
        }
        try (FileInputStream fis = new FileInputStream(formFilePath);FileOutputStream fos =new FileOutputStream(toFilePath)){
            int len = 0;
            byte[] bytes = new byte[1024];
            long okFileLen = 0;//已经复制的大小
            long theSame = 0;//防止单个百分比多次输出
            while ((len=fis.read(bytes))!=-1){
                fos.write(bytes);
                okFileLen += len;
                long inTheSame = okFileLen*100/fileLen;//目前复制了多少占比了
                //如果文件过大，会出现多个同样的百分比，这里的作用就是让其只输出一次百分比
                if(theSame != inTheSame) {
                    long end = System.currentTimeMillis();
                    theSame = inTheSame;
                    System.out.println(name+"文件已复制"+inTheSame+"%，花费了"+(end-first)+"ms");
                }
            }
            long end = System.currentTimeMillis();
            System.out.println("复制完成,总共花费了"+(end-first)+"ms");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

