import com.spring.controller.UserController;
import com.spring.dao.UserDao;
import com.spring.dao.impl.UserDaoImpl;
import com.spring.pojo.User;
import com.spring.service.UserService;
import com.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/14 11:08
 **/
public class TestSpring {
    @Test
    public void testCorwFolw(){
        //前端发请求 ---> controller --> service --> dao --> mysql
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-one.xml");
        UserController uc = ioc.getBean(UserController.class);
        uc.add(new User());
    }

    @Test
    public void testIOC(){
        //读取spring配置文件(启动服务器有个组件给帮你读)
        //ioc类型是ApplicationContext属于IOC容器对象
        //里面保存是spring创建所有bean
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-one.xml");
        //参数可以为：bean的id(需要强转)       class对象     id,class对象
        User u1=(User) ioc.getBean("u");
        //User u2 = ioc.getBean(User.class);
        User u3 = ioc.getBean("u",User.class);
        System.out.println(u1);
        //System.out.println(u2);
        System.out.println(u3);
    }

    @Test
    public void testConstructor(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-one.xml");
        User u = ioc.getBean("u2",User.class);
        System.out.println(u);
    }

    @Test
    public void testAnnotation(){
        ApplicationContext ioc = new ClassPathXmlApplicationContext("spring-two.xml");
        UserController uc = ioc.getBean("uc",UserController.class);
        // UserService us = ioc.getBean("us", UserServiceImpl.class);
        // UserDao ud = ioc.getBean("ud", UserDaoImpl.class);
        // System.out.println(uc);
        // System.out.println(us);
        // System.out.println(ud);
        uc.add(new User());
    }
}
