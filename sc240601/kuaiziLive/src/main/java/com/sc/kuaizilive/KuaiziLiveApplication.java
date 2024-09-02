package com.sc.kuaizilive;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sc.kuaizilive.mapper")
public class KuaiziLiveApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuaiziLiveApplication.class, args);
    }

}
