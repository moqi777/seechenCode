import org.junit.jupiter.api.Test;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/7/31 1:14
 **/
public class Main {
    @Test
    public void main(){
        a();
        b();
    }

    public void a(){
        Integer num1 = 100;
        Integer num2 = 100;
        System.out.println(num1==num2);
    }
    public void b(){
        Integer num1 = 200;
        Integer num2 = 200;
        System.out.println(num1==num2);
    }
}
