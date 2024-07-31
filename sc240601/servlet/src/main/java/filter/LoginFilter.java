package filter;

import pojo.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:登录拦截过滤器
 * 如果用户正常登录了，是可以正常使用的
 * 咩有登录 不能使用登录后的所有页面
 * @DateTime:2024/7/31 11:33
 **/
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //如何判断是否登录
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();
        User u = (User) session.getAttribute("loginUser");
        String path = req.getRequestURI();
        if (u!=null || path.equals("/day2/login.jsp")){//说明登录过
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            ((HttpServletResponse)servletResponse).sendRedirect("/day2/login.jsp");
        }
    }

    public void destroy() {

    }
}
