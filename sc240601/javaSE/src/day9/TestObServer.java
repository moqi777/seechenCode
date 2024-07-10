package day9;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试观察者模式：案例 公司-员工
 * @DateTime:2024/7/10 10:32
 **/
public class TestObServer {
    public static void main(String[] args) {
        ///定义一个主题对象：公司
        CompanySubject com = new Company();
        //定义观察者对象：可以是一个 可以是多个
        Observer o1 = new Employee("张三");
        Observer o2 = new Employee("李四");
        Observer o3 = new Employee("王五");
        //先入职
        com.add(o1);
        com.add(o2);
        com.add(o3);
        //公司发布了新的消息：今天发工资了
        com.update("今天发工资了");
        //有人觉得工资太低了 离职了
        com.remove(o2);
        //公司又发布了信息：发现有人离职了 我要涨工资了
        com.update("今天要涨工资了");
    }
}
//员工类：属于观察者 要观察公司的状态
//先定义一个观察者的抽象类
abstract class Observer{
    String name;
    //用于监听 对方是否状态改变 是否更新
    public abstract void update(String msg);
}
//定义员工观察者
class Employee extends Observer{
    public Employee(String name) {
        super.name = name;
    }

    public void update(String msg) {
        System.out.println(name+"观察者收到了公司的通知："+msg);
    }
}
//被观察者：主题类
interface CompanySubject{
    //用于建立依赖关系
    //入职方法
    void add(Observer e);
    //离职方法
    void remove(Observer e);
    //信息改变的方式，内部要实现 关联的员工也要收到通知
    void update(String msg);
}
//具体的被观察者的实现
class Company implements CompanySubject{
    //通过集合保存 他们的依赖关系 用来保存公司的员工
    Set<Observer> set = new HashSet<>();
    public void add(Observer e) {
        System.out.println(e.name+"入职本公司");
        set.add(e);
    }
    public void remove(Observer e) {
        System.out.println(e.name+"已经离职了");
        set.remove(e);
    }
    public void update(String msg) {
        System.out.println("本公司发布了新的通知："+msg);
        //跟公司关联的员工 也必须收到通知
        for (Observer e : set) {
            e.update(msg);
        }
    }
}
