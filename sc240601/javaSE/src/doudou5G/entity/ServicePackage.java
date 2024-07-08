package doudou5G.entity;

import java.io.Serializable;
import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:所有套餐的父类
 * @DateTime:2024/7/4 13:41
 **/
public class ServicePackage implements Serializable {
    double price;//套餐价格

    //父类的方法，只会返回价格
    public HashMap<String,Object> showInfo(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("price",price);
        return map;
    }

    public ServicePackage() {
    }

    public ServicePackage(double price) {
        this.price = price;
    }
}

