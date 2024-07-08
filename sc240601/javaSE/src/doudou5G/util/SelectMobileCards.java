package doudou5G.util;

import doudou5G.entity.MobileCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:查询所有用户信息，返回一个Arraylist
 * @DateTime:2024/7/4 17:48
 **/
public class SelectMobileCards {
    public static List<MobileCard> select(){
        ObjectInputStream ois = null;
        File file = new File("./javaSE/src/doudou5G/mobileCards.xx");
        List<MobileCard> mobileCards = new ArrayList<>();
        try {
            //如果文件存在才会执行查询文件的操作，否则直接reture一个空ArrayList
            if (file.exists()){
                //如果文件为空需要判断，否者读取空文件会报错
                if (file.length()!=0){
                    ois = new ObjectInputStream(new FileInputStream(file));
                    mobileCards = (List<MobileCard>)ois.readObject();
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (ois!=null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //执行到这一步说明文件不存在或位空或执行错误，返回一个空list
        return mobileCards;
    }
}

