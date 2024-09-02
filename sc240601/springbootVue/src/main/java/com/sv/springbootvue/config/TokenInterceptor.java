package com.sv.springbootvue.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sv.springbootvue.pojo.Result;
import com.sv.springbootvue.util.JwtUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:是为了查看 是否存在token
 * @DateTime:2024/8/30 12:32
 **/
@Component
public class TokenInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setCharacterEncoding("utf-8");
        String token = request.getHeader("token");
        System.out.println(token+"-------------------");
        if (token!=null) return true;
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        //用于将java中的对象转成json
        out.write(new ObjectMapper().writeValueAsString(new Result(0,"认证失败")));
        return false;
    }
}
