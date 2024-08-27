package day3;

/**
 * @author:zhengyilong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:测试HashCode
 * @DateTime:2024/6/26 10:19
 **/
public class Demo1_hashcode {
    public static void main(String[] args) {
        //属于Object类的hashcode
        Demo1_hashcode d1 = new Demo1_hashcode();
        System.out.println("d1："+d1.hashCode());
        Demo1_hashcode d2 = new Demo1_hashcode();
        System.out.println("d2："+d2.hashCode());
        Demo1_hashcode d3 = d1;
        System.out.println("d3："+d3.hashCode());

        //基本类型的封类型hash
        Integer num1 =1000;
        Integer num2 = new Integer(100000);
        System.out.println("num1："+num1.hashCode());
        System.out.println("num2："+num2.hashCode());

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        //String类hashcode
        String s1 = "java";
        String s2 = new String("java");
        System.out.println("s1："+s1.hashCode());
        System.out.println("s2："+s2.hashCode());
    }
}

