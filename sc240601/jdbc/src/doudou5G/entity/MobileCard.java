package doudou5G.entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:用户信息实体类
 * @DateTime:2024/7/4 13:38
 **/
public class MobileCard implements Serializable {
    private String cardNumber;//电话号码
    private String userName;//用户姓名
    private String password;//用户密码
    private ServicePackage serPackage;//用户所使用的套餐
    private double consumAmount;//已消费话费
    private double money;//用户总共话费(包括余额和已消费的)
    private int realTalkTime;//剩余通话时长
    private int realSMSCount;//剩余短信数量
    private int realFlow;//剩余流量

    //该方法将所有信息包装成一个map返回
    public HashMap<String,Object> showMeg(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("cardNumber",cardNumber);
        map.put("userName",userName);
        map.put("password",password);
        map.put("serPackage",serPackage);
        map.put("consumAmount",consumAmount);
        map.put("money",money);
        map.put("realTalkTime",realTalkTime);
        map.put("realSMSCount",realSMSCount);
        map.put("realFlow",realFlow);
        return map;

    }

    public MobileCard() {
    }

    public MobileCard(String cardNumber, String userName, String password, ServicePackage serPackage, double consumAmount, double money, int realTalkTime, int realSMSCount, int realFlow) {
        this.cardNumber = cardNumber;
        this.userName = userName;
        this.password = password;
        this.serPackage = serPackage;
        this.consumAmount = consumAmount;
        this.money = money;
        this.realTalkTime = realTalkTime;
        this.realSMSCount = realSMSCount;
        this.realFlow = realFlow;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ServicePackage getSerPackage() {
        return serPackage;
    }

    public void setSerPackage(ServicePackage serPackage) {
        this.serPackage = serPackage;
    }

    public double getConsumAmount() {
        return consumAmount;
    }

    public void setConsumAmount(double consumAmount) {
        this.consumAmount = consumAmount;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getRealTalkTime() {
        return realTalkTime;
    }

    public void setRealTalkTime(int realTalkTime) {
        this.realTalkTime = realTalkTime;
    }

    public int getRealSMSCount() {
        return realSMSCount;
    }

    public void setRealSMSCount(int realSMSCount) {
        this.realSMSCount = realSMSCount;
    }

    public int getRealFlow() {
        return realFlow;
    }

    public void setRealFlow(int realFlow) {
        this.realFlow = realFlow;
    }
}

