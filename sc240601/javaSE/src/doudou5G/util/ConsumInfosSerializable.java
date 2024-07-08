package doudou5G.util;

import doudou5G.entity.ConsumInfo;
import doudou5G.entity.MobileCard;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:传进来一条消费记录，将其持久化到对应的号码列表中
 * @DateTime:2024/7/5 0:20
 **/
public class ConsumInfosSerializable {
    public static void start(ConsumInfo consumInfo){
        HashMap<String, Object> map = consumInfo.showInfo();
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        File file = new File("./javaSE/src/doudou5G/consumInfos.xx");
        try {
            Map<String,List<ConsumInfo>> consumInfos;
            //如果文件不存在，new一个map将传入的该条消费记录传入
            if (!file.exists()){
                file.createNewFile();
                consumInfos = new HashMap<>();
                //创建一个用户的消费list
                List<ConsumInfo> consumInfoList = new ArrayList<>();
                consumInfoList.add(consumInfo);
                //将该条list存入map
                consumInfos.put((String) map.get("cardNumber"),consumInfoList);
            }else {
                //如果文件存在，从文件中取出map
                ois = new ObjectInputStream(new FileInputStream(file));
                consumInfos = (Map<String,List<ConsumInfo>>)ois.readObject();
                //从map中取出对应用户的list
                List<ConsumInfo> consumInfoList = consumInfos.get((String) map.get("cardNumber"));
                //如果map.get该用户数据为空，说明是第一次消费记录，需要创建一个用户的消费list
                if (consumInfoList==null){
                    consumInfoList = new ArrayList<>();
                }
                //存入一条消费记录
                consumInfoList.add(consumInfo);
                //取出后将传入一条消费记录的list存入map
                consumInfos.put((String) map.get("cardNumber"),consumInfoList);
                ois.close();
            }
            oos = new ObjectOutputStream(new FileOutputStream(file));
            //将map持久化
            oos.writeObject(consumInfos);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois!=null) ois.close();
                if (oos!=null) oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

