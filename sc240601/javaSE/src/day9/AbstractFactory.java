package day9;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:抽象工厂模式实现
 * @DateTime:2024/7/9 11:28
 **/
public interface AbstractFactory {
    ProductA getBeanA();
    ProductB getBeanB();
    //...
}
//具体工程1：按照第一种逻辑实现（活动时间）
class Factory1 implements AbstractFactory{
    public ProductA getBeanA() {
        //活动业务 可以做的代码
        return new ProductAimpl();
    }
    public ProductB getBeanB() {
        return new ProductBimp2();
    }
}
//具体工程2：按照第一种逻辑实现（正常时间）
class Factory2 implements AbstractFactory{
    public ProductA getBeanA() {
        //正常业务 可以做的代码
        return new ProductAimpl();
    }
    public ProductB getBeanB() {
        return new ProductBimp2();
    }
}
//具体工程2：按照第二种逻辑实现（正常时间）
//产品1接口
interface ProductA{
    void prodectA();
}
//具体产品实现
class ProductAimpl implements ProductA{
    public void prodectA() {
        System.out.println("开始生产产品A1");
    }
}
class ProductAimp2 implements ProductA{
    public void prodectA() {
        System.out.println("开始生产产品A2");
    }
}
//产品2接口
interface ProductB{
    void productB();
}
class ProductBimpl implements ProductB{
    public void productB() {
        System.out.println("开始生产产品B1");
    }
}
class ProductBimp2 implements ProductB{
    public void productB() {
        System.out.println("开始生产产品B2");
    }
}

class Main1{
    public static void main(String[] args) {
        //1.具体工厂1
        AbstractFactory factory1 = new Factory1();
        factory1.getBeanA().prodectA();
        factory1.getBeanB().productB();
        //2.具体工厂2
        AbstractFactory factory2 = new Factory2();
        factory2.getBeanA().prodectA();
        factory2.getBeanB().productB();
    }
}