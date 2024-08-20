package day1;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/19 19:38
 **/
public class TestVar {
    String sex;
    // var age = 18;    错误2
    // public void test(var a){}    错误4
    // public var test(){}      错误5
    public static void main(String[] args) {
        String a = "aaa";
        int b=111;
        var c=true;
        var d=15.5;
        // var e;   错误1

        MyInterface my = (String aa,int bb)->{

        };
        MyInterface my2 = (aa,bb)->{

        };
        //错误3   形参类型 要么都写var 要么都不写
        MyInterface my3 = (var aa,var bb)->{

        };
    }
}
//函数式接口
interface MyInterface{
    public void my(String a,int b);
}