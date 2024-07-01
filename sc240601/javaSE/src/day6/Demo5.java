package day6;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试重复加载的问题
 * @DateTime:2024/7/1 16:48
 **/
public class Demo5 {
    public static void main(String[] args) {
        Object obj = new Object();
        obj.name="张三";
        System.out.println(obj.name);
    }
}
