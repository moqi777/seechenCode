package com.sc.order.config;

import feign.Logger;
import feign.Request;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/14 14:25
 **/
//需要OpenFeign依赖：order-->goods
//                 order-->stock
//OpenFeign也提供四种日志级别 对应下面四个常量
//NONE：默认值 表示不记录任何日志
//BASIC：仅仅记录请求方法 URL，响应状态码，以及请求执行的时间
//HEADERS：记录 包含BASIC信息 还记录请求和响应header信息
//FULL：记录包含HERDERS信息 还记录请求和响应的body信息和元数据

//总结：以上这四种日志对于SpringBoot而言都是debug级别的日志
//需要在SpringBoot指定好特定包日志级别
@Configuration
public class OpenFeignConfig {
    @Bean
    Logger.Level level(){
        return Logger.Level.FULL;
    }
    //配置类 和配置文件 都可以实现 超时时间配置 只需要配置一种
    @Bean
    Request.Options options(){
        //参数1：连接超时时间  参数2：请求处理超时时间   单位毫秒
        return new Request.Options(2000,5000);
    }
}
