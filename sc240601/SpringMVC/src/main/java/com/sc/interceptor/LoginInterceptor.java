package com.sc.interceptor;

import com.sc.pojo.Usermvc;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/6 15:34
 **/
public class LoginInterceptor implements HandlerInterceptor {
    //1.控制层方法执行之前调用进行拦截
    //return true：表示可以访问控制层方法
    //return false：无法访问
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Usermvc user = (Usermvc) request.getSession().getAttribute("user");
        if (user==null){
            response.sendRedirect("/index.jsp");
            return false;
        }
        return true;
    }
    //2.在控制层方法调用之后 视图解析器之前执行
    //一般通过它 对请求作用域的数据 进行二次修改
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }
    //3.在控制层方法执行结束并且返回了 视图解析器也完毕了 才调用
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
