package doudou5G.entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:每个用户的卡消费信息实体类
 * @DateTime:2024/7/5 0:08
 **/
public class ConsumInfo implements Serializable {
    private String cardNumber;//卡号
    private String type;//通话 短信 流量
    private int consumData;//消费数据 +多少 或者-多少

    public HashMap<String, Object> showInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("cardNumber",cardNumber);
        map.put("type",type);
        map.put("consumData",consumData);
        return map;
    }

    public ConsumInfo() {
    }

    public ConsumInfo(String cardNumber, String type, int consumData) {
        this.cardNumber = cardNumber;
        this.type = type;
        this.consumData = consumData;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getConsumData() {
        return consumData;
    }

    public void setConsumData(int consumData) {
        this.consumData = consumData;
    }
}

