import com.spring2.pojo.Emp;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 19:28
 **/
public class Test1 {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Emp emp = context.getBean("emp", Emp.class);
        System.out.println(emp);
    }
    @Test
    public void test2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Emp emp = context.getBean("emp2", Emp.class);
        System.out.println(emp);
    }
}
