package com.sc.kuaizilive.config;

import com.sc.kuaizilive.Interceptor.TokenInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:配置拦截器
 * @DateTime:2024/9/3 11:05
 **/
//先注掉不用
// @Configuration
public class InterceptorConfig implements WebMvcConfigurer{
    @Autowired
    private TokenInterceptor interceptor;
    //配置类配置哪些请求被拦截 哪些请求放行
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(interceptor)    //添加拦截器对象
                .addPathPatterns("/**") //配置拦截的地址
                .excludePathPatterns(); //配置放行地址
        //调用父类的方法 才可以生效
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
