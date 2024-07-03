package day8;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:枚举
 * @DateTime:2024/7/3 10:43
 **/
//枚举：是jdk1.5支持的一个类型，关键字enum
//其实跟class基本一样，同样可以保存 成员变量 构造方法 静态方法...
//但是枚举固定要求：构造方法 必须私有化的（否则报错）
//枚举还会保存很多常量 是常量的个数来控制构造方法执行的次数
public class Demo2_enum {
    public static void main(String[] args) {
        MyEnum2 m1 = MyEnum2.ONE;
        MyEnum2 m2 = MyEnum2.ONE;
        MyEnum2 m3 = MyEnum2.TWO;
        MyEnum2 m4 = MyEnum2.TWO;
        MyEnum2 m5 = MyEnum2.THREE;
        MyEnum2 m6 = MyEnum2.THREE;

        //switch也支持枚举
        switch (m3){
            case ONE:
                System.out.println("one");break;
            case TWO:
                System.out.println("two");break;
            case THREE:
                System.out.println("three");break;

        }
    }
}
enum MyEnum1{
    //定义三个常量(不是final 是枚举对标构造方法的)
    //最终也只会调用三次构造方法 就算是反射也没用
    ONE,WUO,THREE;
    MyEnum1(){}

    String name;//成员变量
    public void test(){}
    public static void test2(){}
}
enum MyEnum2{
    ONE,TWO("11"),THREE("",10);
    private MyEnum2(){
        System.out.println("无参");
    }
    private MyEnum2(String name){
        System.out.println("一个参数");
    }
    private MyEnum2(String name,int age){
        System.out.println("两个参数");
    }
}

