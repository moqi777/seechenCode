package day6;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:类加载器
 * @DateTime:2024/7/1 16:08
 **/
public class Demo4 {
    public static void main(String[] args) {
        //获取系统类加载器（应用程序类加载器）
        ClassLoader cl1 = ClassLoader.getSystemClassLoader();
        System.out.println("系统类加载器："+cl1);
        //系统类父加载器就是平台类加载器（扩展类加载器）
        ClassLoader cl2 = cl1.getParent();
        System.out.println("平台类加载器："+cl2);
        //平台类加载器父类加载器就是启动类加载器
        ClassLoader cl3 = cl2.getParent();
        System.out.println("启动类加载器："+cl3);
    }
}

