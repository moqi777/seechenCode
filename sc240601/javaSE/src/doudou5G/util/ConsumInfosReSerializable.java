package doudou5G.util;

import doudou5G.entity.ConsumInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:根据传进来的电话号码查询到对应的消费记录
 * @DateTime:2024/7/5 11:52
 **/
public class ConsumInfosReSerializable {
    public static List<ConsumInfo> start(String cardNumber){
        ObjectInputStream ois = null;
        File file = new File("./javaSE/src/doudou5G/consumInfos.xx");
        try {
            //如果文件不存在，直接return
            if (!file.exists()){
                System.out.println("消费清单查询失败！！！");
                return null;
            }else {
                //如果文件存在，从文件中取出map
                ois = new ObjectInputStream(new FileInputStream(file));
                Map<String,List<ConsumInfo>> consumInfos = (Map<String,List<ConsumInfo>>)ois.readObject();
                //从map中取出对应用户的list
                List<ConsumInfo> consumInfoList = consumInfos.get(cardNumber);
                //如果map.get该用户数据为空，返回没有消费记录
                if (consumInfoList==null){
                    System.out.println("未查询到该用户消费记录！！！");
                    return null;
                }
                //返回该用户的消费清单
                return consumInfoList;
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois!=null) ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}

