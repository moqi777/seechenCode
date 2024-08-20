package com.springboot.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:跨域过滤器配置类
 * @DateTime:2024/8/20 14:39
 **/
@Configuration
public class CrossOriginFilterConfig {
    @Bean
    public CorsFilter corsFilter(){
        return new CorsFilter(source());
    }
    @Bean
    public CorsConfigurationSource source(){
        UrlBasedCorsConfigurationSource source =
                new UrlBasedCorsConfigurationSource();
        //注册跨域配置：参数1：允许的跨域路径 参数2：设置规则
        source.registerCorsConfiguration("/**",config());
        return source;
    }
    @Bean
    public CorsConfiguration config(){
        CorsConfiguration config = new CorsConfiguration();
        //设置规则
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);
        return config;
    }
}
