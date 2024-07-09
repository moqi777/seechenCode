package day9;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:工厂方法模式
 * @DateTime:2024/7/9 11:14
 **/
public interface MethodFactory {
    Animal getBean();
}
class FactoryA implements MethodFactory{
    public Animal getBean() {
        return new Tiger();
    }
}
class FactoryB implements MethodFactory{
    public Animal getBean() {
        return new Dog();
    }
}
class FactoryC implements MethodFactory{
    public Animal getBean() {
        return new Penguni();
    }
}

class Main{
    public static void main(String[] args) {
        MethodFactory m1 = new FactoryA();
        MethodFactory m2 = new FactoryB();
        MethodFactory m3 = new FactoryC();
        m1.getBean().eat();
        m2.getBean().eat();
        m3.getBean().eat();
    }
}


