package controller;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:Servlet生命周期
 * @DateTime:2024/7/30 16:04
 **/
public class CycleServlet implements Servlet {
    //1.初始化的方法：是为了Servlet环境使用的方法
    //比如：设置一些初值 设置初始化参数 配置一些全局参数
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet初始化，默认第一次发送请求才会执行，" +
                "缺点是第一次发送请求就有可能有延迟，启动服务器再做servlet比较合适");
        //init()中如何获取初始化参数
        String reqValue = servletConfig.getInitParameter("reqCharSet");
        System.out.println("CycleController："+reqValue);

        //init()获取全局参数
        String respValue = servletConfig.getServletContext().getInitParameter("respCharset");
        System.out.println("CycleController："+respValue);
    }
    //2.接收请求并且处理请求的方法，HttpServlet实现底层就是service
    //service() 负责接受请求 判断请求方式 进而调用doGet doPost
    public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        System.out.println("接收到了请求，每发送一次请求执行一次");
    }
    //3.销毁Servlet
    public void destroy() {
        System.out.println("servlet开始销毁，服务器关闭时执行一次");
    }
    //获取Serice信息
    public String getServletInfo() {
        return null;
    }
    //获取Config对象
    public ServletConfig getServletConfig() {
        return null;
    }
}
