package doudou5G.util;

import doudou5G.entity.MobileCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:将注册成功的用户持久化
 * @DateTime:2024/7/4 16:54
 **/
public class RegSerializable {
    //该方法将传入的用户持久化追加进文件中的用户list中，如果重复，覆盖写入
    public static void start(MobileCard mobileCard){
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        File file = new File("./javaSE/src/doudou5G/mobileCards.xx");
        try {
            List<MobileCard> mobileCards = null;
            if (!file.exists()){
                file.createNewFile();
                mobileCards = new ArrayList<>();
                mobileCards.add(mobileCard);
            }else {
                ois = new ObjectInputStream(new FileInputStream(file));
                mobileCards = (List<MobileCard>)ois.readObject();
                //寻找是否有重复list元素
                for (int i = 0; i < mobileCards.size(); i++) {
                    //注册时提供给用户的号码不可能重复，因为在号码生成的时候对数据库进行了遍历排除
                    //如果有重复的，将原先的删除实现覆盖写入（此处主要是为了方法的复用性，使该方法不仅用于注册，还可以用于用户通话发短信上网时的修改）
                    if (mobileCards.get(i).getCardNumber().equals(mobileCard.getCardNumber())){
                        mobileCards.remove(i);
                    }
                }
                mobileCards.add(mobileCard);
                ois.close();
            }
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(mobileCards);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if (ois!=null) ois.close();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

