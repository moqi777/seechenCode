package doudou5G.util;

import doudou5G.entity.MobileCard;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:删除用户
 * @DateTime:2024/7/6 11:56
 **/
public class DeleteMobileCard {
    public static boolean delete(MobileCard mobileCard){
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        File file = new File("./javaSE/src/doudou5G/mobileCards.xx");
        try {
            List<MobileCard> mobileCards = null;
            if (!file.exists()){
                System.out.println("删除失败，存储用户信息文件不存在");
                return false;
            }else {
                ois = new ObjectInputStream(new FileInputStream(file));
                mobileCards = (List<MobileCard>)ois.readObject();
                //寻找是否有重复list元素
                for (int i = 0; i < mobileCards.size(); i++) {
                    //如果有重复的，将原先的删除，没有重复的就不管，正常逻辑下不会没有重复的
                    if (mobileCards.get(i).getCardNumber().equals(mobileCard.getCardNumber())){
                        mobileCards.remove(i);
                    }
                }
                ois.close();
            }
            oos = new ObjectOutputStream(new FileOutputStream(file));
            oos.writeObject(mobileCards);
            return true;//即使return后finally中的代码依旧会执行，所以不用担心流未关闭的问题
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
        return false;//到了这一步说明异常了
    }
}

