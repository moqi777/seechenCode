package com.sv.springbootvue.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/11 16:37
 **/
@Configuration
@CacheConfig //缓存配置
@EnableCaching //开启注解缓存
public class RedisConfig {
    //因为配置文件写了 集群节点地址
    //服务器启动后 自动创建连接工厂 所以spring容器就会存在这个对象
    //目前报错是正常的 因为需要启动服务器才会创建
    @Autowired
    RedisConnectionFactory factory;
    //RedisTemplate 以后操作redis核心对象
    @Bean
    RedisTemplate<String,Object> redisTemplate(){
        RedisTemplate<String, Object> rt = new RedisTemplate<>();
        //1.指定key序列化方式 字符串
        rt.setKeySerializer(new StringRedisSerializer());
        rt.setHashKeySerializer(new StringRedisSerializer());
        //2.指定value序列化方式 json
        rt.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        rt.setHashValueSerializer(new GenericJackson2JsonRedisSerializer());
        //3.设置连接工厂
        rt.setConnectionFactory(factory);
        return rt;
    }

    //假设 以后节点有很多 不方便写配置文件ip:端口，借助于配置类直接把连接工程创建出来
    //但是实际上还是更多的在配置文件中写，因为ip地址也是没有规律的
    // @Bean
    // RedisConnectionFactory factory(){
    //     Set<String> nodes = new HashSet<>();
    //     for (int i = 7000; i < 70005; i++) {
    //         nodes.add("192.168.11.27:"+i);
    //     }
    //     RedisClusterConfiguration cluster = new RedisClusterConfiguration(nodes);
    //     return new JedisConnectionFactory(cluster);
    // }
}
