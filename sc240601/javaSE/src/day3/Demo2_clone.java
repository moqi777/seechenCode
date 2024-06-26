package day3;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:浅克隆 深克隆
 * @DateTime:2024/6/26 10:43
 **/
public class Demo2_clone {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A();
        A a2 = (A)a.clone();
        System.out.println(a);//day3.A@1540e19d
        System.out.println(a2);//day3.A@677327b6
        a.id=100;
        a.name="张三";
        a.b.name="李四";
        System.out.println(a.id+" "+a.name+" "+a.b.name);//100 张三 李四
        System.out.println(a2.id+" "+a2.name+" "+a2.b.name);//null null null
    }
}
//深克隆
class A implements Cloneable{
    Integer id;
    String name;
    B b = new B();
    @Override
    protected Object clone() throws CloneNotSupportedException {
        A a = (A) super.clone();
        a.b=(B) b.clone();
        return a;
    }
}
class B implements Cloneable{
    Integer id;
    String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

