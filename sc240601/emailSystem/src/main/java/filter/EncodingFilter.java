package filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:编码过滤器
 * @DateTime:2024/7/31 19:06
 **/
public class EncodingFilter implements Filter {
    String reqCharSet;
    String respCharSet;
    public void init(FilterConfig filterConfig) throws ServletException {
        reqCharSet = filterConfig.getInitParameter("reqCharSet");
        respCharSet = filterConfig.getInitParameter("respCharSet");
        System.out.println("编码过滤器启动成功，req编码："+reqCharSet);
        System.out.println("编码过滤器启动成功，resp编码："+respCharSet);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(reqCharSet);
        servletResponse.setContentType(respCharSet);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {

    }
}
