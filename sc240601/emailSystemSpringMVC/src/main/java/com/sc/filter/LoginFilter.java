package com.sc.filter;

import com.sc.pojo.EmailUser;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:登录过滤器，如果没有登录只能访问登录和注册页面
 * @DateTime:2024/7/31 19:29
 **/
public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        EmailUser user = (EmailUser)session.getAttribute("loginUser");
        if (user == null) {
            System.out.println("进行了一次登录过滤，失败，返回主页面");
            ((HttpServletResponse)servletResponse).sendRedirect("/index.jsp");
        }else {
            System.out.println("进行了一次登录过滤，放行");
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
