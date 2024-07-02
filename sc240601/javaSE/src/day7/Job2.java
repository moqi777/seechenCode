package day7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/2 19:44
 **/
//从键盘输入接收一个文件夹路径,打印出该文件夹下所有的.java后缀的文件名
//   拓展: 如果同时还包括所有子文件该如何实现
public class Job2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个文件夹路径");
        String next = scanner.next();
        getClassFile(next);
    }

    public static void getClassFile(String next){
        File file = new File(next);
        if(file.isDirectory()&&file.exists()){
            //.list 返回该目录下所有的文件名和文件夹名，参数：过滤器
            String[] list = file.list((dir,name)->{
                //.endsWith 检测字符串是否有指定后缀
                return name.endsWith(".java");
            });
            //过滤出所有文件夹
            String[] dirs = file.list((dir, name) -> {
                return !name.contains(".");//判断这个名字中是否包含点，如果包含了说明是文件，就过滤掉，剩下的都是文件夹
            });
            //循环输出这层的class文件
            for (String s : list) {
                System.out.println(s.substring(0,s.lastIndexOf(".")));
            }
            //如果还存在文件夹，递归调用
            if (dirs.length!=0){
                for (String dir : dirs) {
                    getClassFile(next+"\\"+dir);
                }
            }
        }else {
            System.out.println("不是文件夹或该路径不存在");
        }
    }
}

