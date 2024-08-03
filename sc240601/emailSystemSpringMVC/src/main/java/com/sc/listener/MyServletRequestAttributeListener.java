package com.sc.listener;

import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import java.time.LocalDateTime;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:监控request里面属性（新增 删除 替换）
 * @DateTime:2024/7/31 21:15
 **/
public class MyServletRequestAttributeListener implements ServletRequestAttributeListener {
    public void attributeAdded(ServletRequestAttributeEvent srae) {
        String time = LocalDateTime.now().toString();
        String name = srae.getName();//属性名
        Object value = srae.getValue();//属性值
        System.out.println(time+"新增了request作用域，属性名："+name+",属性值："+value);
    }

    public void attributeRemoved(ServletRequestAttributeEvent srae) {
        String time = LocalDateTime.now().toString();
        String name = srae.getName();//属性名
        Object value = srae.getValue();//属性值
        System.out.println(time+"删除了request作用域，属性名："+name+",属性值："+value);
    }

    public void attributeReplaced(ServletRequestAttributeEvent srae) {
        String time = LocalDateTime.now().toString();
        String name = srae.getName();//属性名
        Object oldValue = srae.getValue();//替换前的属性值
        Object newValue = srae.getServletRequest().getAttribute(name);//替换后的属性值
        System.out.println(time+"替换了request作用域，属性名："+name+",原属性值："+oldValue+",新属性值："+newValue);
    }
}
