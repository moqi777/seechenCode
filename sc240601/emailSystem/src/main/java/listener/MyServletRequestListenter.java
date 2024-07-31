package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:监控request创建和销毁
 * @DateTime:2024/7/31 21:14
 **/
public class MyServletRequestListenter implements ServletRequestListener {
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("创建request作用域");
    }

    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("删除resuest作用域");
    }
}
