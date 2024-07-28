import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/25 18:39
 **/
public class Fanzhuan {

//    几个简单的注解 就可以让一个方法启动运行
//    它的底层说白了也是主函数 实现也是main()实现的
//    bug:不兼容 Scanner对象
    @Test
    public void go(){
        //-2,147,483,648 到 2,147,483,647
        int sum = 746384742;
        String s = new StringBuilder(new Integer(sum).toString()).reverse().toString();
        if (sum<0) s = "-"+s.substring(0,s.length()-1);
        try {
            int num = new Integer(s);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println(0);
        }
    }

    @Before
    public void a(){
        System.out.println("前");
    }
    @After
    public void b(){
        System.out.println("后");
    }
}
