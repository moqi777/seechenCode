package day9;

import com.sun.org.apache.bcel.internal.generic.SIPUSH;

import java.text.SimpleDateFormat;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:简单工厂模式实现
 * @DateTime:2024/7/9 10:38
 **/
public class SimpleFactory {
    //一个方法：根据参数返回不用的对象
    public static Animal getBran(String type){
        if ("A".equals(type)){
            return new Tiger();
        }else if ("B".equals(type)){
            return new Dog();
        }else if("C".equals(type)){
            return new Penguni();
        }else {
            throw new RuntimeException("咩有合适的对象");
        }
    }

    public static void main(String[] args) {
        Animal a1 = SimpleFactory.getBran("A");
        Animal a2 = SimpleFactory.getBran("B");
        Animal a3 = SimpleFactory.getBran("C");
        try {
            Animal a4 = SimpleFactory.getBran("D");
            a4.eat();
        }catch (Exception e){
            e.printStackTrace();
        }
        a1.eat();
        a2.eat();
        a3.eat();
    }
}

abstract class Animal{
    public abstract void eat();
}
class Tiger extends Animal{
    @Override
    public void eat() {
        System.out.println("老虎吃肉");
    }
}
class Dog extends Animal{
    @Override
    public void eat() {
        System.out.println("狗吃骨头");
    }
}
class Penguni extends Animal{
    @Override
    public void eat() {
        System.out.println("企鹅吃鱼");
    }
}

