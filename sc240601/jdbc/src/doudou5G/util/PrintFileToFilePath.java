package doudou5G.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:根据文件路径输出文件内容在控制台
 * @DateTime:2024/7/6 12:22
 **/
public class PrintFileToFilePath {
    public static void start(String file){
        File f = new File(file);
        if (!f.exists()){
            System.out.println("文件不存在");
            return;
        }
        //此处需要用字节流，使用字符流会输出不完整
        try (FileInputStream fis = new FileInputStream(f)){
            int len;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

