package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:监控session创建和销毁
 * @DateTime:2024/7/31 21:14
 **/
public class MyHttpSessionListenter implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("创建session作用域");
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("销毁session作用域");
    }
}
