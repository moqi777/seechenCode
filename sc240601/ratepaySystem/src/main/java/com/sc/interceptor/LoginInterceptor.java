package com.sc.interceptor;

import com.sc.pojo.Uuser;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/7 20:58
 **/
public class LoginInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Uuser loginUuser = (Uuser) request.getSession().getAttribute("loginUuser");
        if (loginUuser!=null) return true;
        response.sendRedirect("/uuser/toLogin");
        return false;
    }
}
