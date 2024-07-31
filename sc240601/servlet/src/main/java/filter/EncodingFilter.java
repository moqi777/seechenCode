package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:编码过滤器
 * @DateTime:2024/7/31 10:56
 **/
public class EncodingFilter implements Filter {
    String reqValue;
    //过滤器初始化，实现初始化参数 全局参数的设置
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化编码过滤器，默认服务器启动做初始化");
        //获取初始化参数：
        reqValue = filterConfig.getInitParameter("reqCharSet");
    }
    //过滤器的核心方法：过滤规则
    //参数1 和  2：表示请求和响应
    //参数3：用于实现后续处理的（放行资源）
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("进行过滤规则");
        //获取全局参数
        ServletContext app = servletRequest.getServletContext();
        String respValue = app.getInitParameter("respCharset");

        servletRequest.setCharacterEncoding(reqValue);
        servletResponse.setContentType(respValue);
        //如果资源满足后：放行处理的（如果后面还有过滤器 则进入第二过滤器 如果没有则进入Servlet）
        filterChain.doFilter(servletRequest,servletResponse);
    }
    //过滤器销毁
    public void destroy() {
        System.out.println("销毁编码过滤器：服务器关闭销毁");
    }
}
