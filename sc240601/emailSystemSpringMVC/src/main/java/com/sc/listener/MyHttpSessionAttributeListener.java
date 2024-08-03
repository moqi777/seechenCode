package com.sc.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.time.LocalDateTime;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:监控session里面属性（新增 删除 替换）
 * @DateTime:2024/7/31 21:15
 **/
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {
    public void attributeAdded(HttpSessionBindingEvent event) {
        String time = LocalDateTime.now().toString();
        String name = event.getName();//属性名
        Object value = event.getValue();//属性值
        System.out.println(time+"新增了session作用域，属性名："+name+",属性值："+value);
    }

    public void attributeRemoved(HttpSessionBindingEvent event) {
        String time = LocalDateTime.now().toString();
        String name = event.getName();//属性名
        Object value = event.getValue();//属性值
        System.out.println(time+"删除了session作用域，属性名："+name+",属性值："+value);
    }

    public void attributeReplaced(HttpSessionBindingEvent event) {
        String time = LocalDateTime.now().toString();
        String name = event.getName();//属性名
        Object oldValue = event.getValue();//替换前的属性值
        Object newValue = event.getSession().getAttribute(name);//替换后的属性值
        System.out.println(time+"替换了session作用域，属性名："+name+",原属性值："+oldValue+",新属性值："+newValue);
    }
}
