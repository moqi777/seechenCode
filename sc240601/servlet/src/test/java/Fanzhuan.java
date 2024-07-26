import org.junit.Test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/25 18:39
 **/
public class Fanzhuan {
    @Test
    public void go(){
        //-2,147,483,648 到 2,147,483,647
        int sum = 746384742;
        String s = new StringBuilder(sum).reverse().toString();
        if (sum<0) s = "-"+s.substring(0,s.length()-1);
        try {
            int num = new Integer(s);
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println(0);
        }
    }
}
