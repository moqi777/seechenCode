package com.springboot.springboot.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:配置类：spring把不经常修改的配置通过类来完成
 * 编写方式：1.类添加@Configuration 标注这个类是配置类
 *         2.编写方法 它的返回值就是spring容器需要创建的对象
 *         并且这个方法添加@Bean注解 等价于之前的bean标签
 *         它会把方法的返回值创建bean对象 存储在spring容器中
 * @DateTime:2024/8/20 11:15
 **/
//@Configuration
public class MyConfig {
    //只要在容器中的类(MyConfig Controller Service...)
    //中都可以获取到配置文件的内容
    //获取方式添加一个注解@Value("${key}")
    @Value("${my.url}")
    String url;
    @Value("${my.driver}")
    String driver;
    @Value("${my.username}")
    String username;
    @Value("${my.password}")
    String password;

    @Bean
    DataSourceProperties test(){
        DataSourceProperties p = new DataSourceProperties();
        p.setUrl(url);
        p.setDriverClassName(driver);
        p.setUsername(username);
        p.setPassword(password);
        return p;
    }
    @Bean
    DataSourceTransactionManager test2(){
        DataSourceTransactionManager dt = new DataSourceTransactionManager();
        //test() 返回值是模拟的不是DataSource
        // dt.setDataSource(test());
        return dt;
    }
}
