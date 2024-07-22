package doudou5G.entity;

import java.util.HashMap;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:场景实体类
 * @DateTime:2024/7/5 0:12
 **/
public class Scene {
    private String type;//通话 短信 还是流量
    private int data;//数据
    private String description;//描述说明

    public HashMap<String, Object> showInfo() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("type",type);
        map.put("data",data);
        map.put("description",description);
        return map;
    }

    public Scene() {
    }

    public Scene(String type, int data, String description) {
        this.type = type;
        this.data = data;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

