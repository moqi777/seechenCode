package listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:session域对象属性监听器：目的是检测session里面的属性
 * 如果新增 删除 替换 都可以检测出来
 * @DateTime:2024/7/31 15:43
 **/
public class MySessionAttributeListener implements HttpSessionAttributeListener {
    //session属性如果添加了 就会自定执行
    //比如：登录 新增用户信息
    public void attributeAdded(HttpSessionBindingEvent event) {
        //什么时间 新增了属性 属性名 属性值
        String time = LocalDateTime.now().toString();
        String name = event.getName();//属性名
        Object value = event.getValue();//属性值
        System.out.println(time+"新增了session作用域，属性名："+name+",属性值："+value);
    }
    //session属性如果删除了 就会自定执行
    //比如：退出登录 删除用户信息
    public void attributeRemoved(HttpSessionBindingEvent event) {
        String time = LocalDateTime.now().toString();
        String name = event.getName();//属性名
        System.out.println(time+"删除了session作用域，属性名："+name);
    }
    //session属性如果替换了 就会自定执行
    //比如：登录成功后没有退出 直接登录第二次
    public void attributeReplaced(HttpSessionBindingEvent event) {
        String time = LocalDateTime.now().toString();
        String name = event.getName();//属性名
        Object oldValue = event.getValue();//替换前的属性值
        Object newValue = event.getSession().getAttribute(name);//替换后的属性值
        System.out.println(time+"替换了session作用域，属性名："+name+",原属性值："+oldValue+",新属性值："+newValue);
    }
}
