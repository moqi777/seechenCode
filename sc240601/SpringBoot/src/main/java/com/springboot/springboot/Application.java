package com.springboot.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication
// @ComponentScan(basePackages = {"com.springboot"})
@MapperScan("com.springboot.springboot.mapper")//整合mapper接口的包 创建mapper接口实现类
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
