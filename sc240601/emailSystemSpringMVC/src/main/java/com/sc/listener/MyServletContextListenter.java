package com.sc.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:监控application创建和销毁
 * @DateTime:2024/7/31 21:14
 **/
public class MyServletContextListenter implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("创建application作用域");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("删除application作用域");
    }
}
