package com.sc.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/20 16:17
 **/
// @Configuration
public class CorsConfig {
    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        //跨域配置对象
        CorsConfiguration config=new CorsConfiguration();
        config.addAllowedMethod("*");//允许请求方式
        config.addAllowedOrigin("*");//允许的来源
        config.addAllowedHeader("*");//允许请求头参数
        //设置允许访问的资源
        source.registerCorsConfiguration("/**",config);
        return new CorsWebFilter(source);
    }
}
