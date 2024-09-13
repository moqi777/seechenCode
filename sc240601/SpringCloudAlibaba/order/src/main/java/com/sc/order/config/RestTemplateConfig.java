package com.sc.order.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/13 15:14
 **/
//配置类：配置RestTemplate 用于远程调用其他服务
@Configuration
public class RestTemplateConfig {
    @Bean
    @LoadBalanced   //开启负载均衡 这样当前服务才可以通过服务名远程访问其他服务
    RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }
}
