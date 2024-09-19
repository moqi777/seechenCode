package com.sc.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ConfigApplication {

    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext ioc =
                SpringApplication.run(ConfigApplication.class, args);
        //测试一下 启动服务器后 写个死循环 不断去读取 cacos config配置中心的数据
        //只要读取成功 就配置没有错误 而且修改后 无需重启是否可以读取最新数据
        while (true){
            //要和配置文件定义的key 对应好
            String un = ioc.getEnvironment().getProperty("user.username");
            String pw = ioc.getEnvironment().getProperty("user.password");
            System.out.println(un+"---------"+pw);
            Thread.sleep(2000);
        }
    }

}
