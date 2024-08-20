package com.springboot.springboot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:跨域配置类
 * @DateTime:2024/8/20 14:17
 **/
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {
    //跨域配置类 不需要创建一个对象(因为springboot已经创建好了)
    //我们需要的是在它创建的对象里面 添加跨域规则
    public void addCorsMappings(CorsRegistry registry) {
        //形参设置允许跨域规则
        registry.addMapping("/**")//设置允许跨域路径
                .allowedOriginPatterns("*")//设置允许跨域域名
                .allowCredentials(true)   //是否允许cookie
                .allowedMethods("GET","POST","PUT","DELETE")//设置允许的请求方式
                .allowedHeaders("*")      //设置允许的头部信息
                .maxAge(3600);            //设置每次跨域的时间 秒
    }
}
