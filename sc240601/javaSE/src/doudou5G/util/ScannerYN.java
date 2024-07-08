package doudou5G.util;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:验证用户输入是否不正确
 * @DateTime:2024/7/4 15:08
 **/
public class ScannerYN {
    //参数1：用户输入的字符串
    //参数2：限定用户输入的起始范围
    //参数3：限定用户输入的终止范围
    //返回值：将用户输入的字符串解析成序号，如果错误返回-1
    public static int verify(String scan,int first,int end){
        ArrayList<String> list = new ArrayList<>();
        for (int i = first; i <=end; i++) {
            list.add(i+"");
        }
        if (!list.contains(scan)){
            System.out.println("错误输入！！！");
            return -1;
        }
        return new Integer(scan);
    }
}

