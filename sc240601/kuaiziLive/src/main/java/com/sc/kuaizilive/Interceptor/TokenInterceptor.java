package com.sc.kuaizilive.Interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sc.kuaizilive.pojo.Result;
import com.sc.kuaizilive.util.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc：拦截用户是否登录了
 * @DateTime:2024/9/3 11:02
 **/
@Component
public class TokenInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        if (JwtUtils.checkToken(token)) return true;
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //用于将java中的对象转成json
        out.write(new ObjectMapper().writeValueAsString(new Result(0,"认证失败")));
        return false;
    }
}
