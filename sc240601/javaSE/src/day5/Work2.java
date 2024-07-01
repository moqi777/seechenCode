package day5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/6/28 10:53
 **/
//有一个单词txt文件 里面存放了很多单词 通过空格相连, 请通过线程
//IO流读取里面的内容,并且统计 每个单词出现的次数 并且按照 次数从大到小排列
public class Work2 {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("./javaSE/src/day5/string.txt"); BufferedReader br = new BufferedReader(fr);){
            StringBuilder sb = new StringBuilder();
            String str = null;
            while ((str = br.readLine())!=null){
                sb.append(str);
            }
            System.out.println(sb);
            String[] strs = sb.toString().split(" ");
            HashMap<String, Integer> map = new HashMap<>();
            for (String s : strs) {
                if(map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else {
                    map.put(s,1);
                }
            }
            //如何排序
            //map集合中的key和value 统称可以叫entry
            //map通过entrySet() 可以把map集合每组键值对 都封装成entry对象返回
            Set<Map.Entry<String, Integer>> set = map.entrySet();
            List<Map.Entry<String, Integer>> list = new ArrayList<>(set);
            Collections.sort(list,(o1,o2)-> o2.getValue() - o1.getValue());
            System.out.println(list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

