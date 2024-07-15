package designMode;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:单例模式实现
 * @DateTime:2024/7/13 15:38
 **/
public class DanLiMode {
    public static void main(String[] args) {
        Animal a = Animal.getA();
        B b = B.get();
    }
}

class Animal{
    private Animal(){}
    private static Animal a = new Animal();
    public static Animal getA(){
        return a;
    }
}

class B{
    private B(){}
    private static B b;
    public synchronized static B get(){
        if (b==null) b=new B();
        return b;
    }
}
