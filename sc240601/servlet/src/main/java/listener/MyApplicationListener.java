package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:监控application作用域 创建 和 销毁的
 * @DateTime:2024/7/31 15:35
 **/
public class MyApplicationListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("application作用域创建");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application作用域销毁");
    }
}
