package com.springboot.springboot.config;

import com.springboot.springboot.controller.AdminController;
import com.springboot.springboot.service.AdminService;
import com.springboot.springboot.service.impl.AdminServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/20 11:39
 **/
//@Configuration
public class MyConfig2 {
    //@Bean
    AdminController getController(){
        AdminController a = new AdminController();
        a.setAs(getService());
        return a;
    }
    //@Bean
    AdminService getService(){
        AdminService as = new AdminServiceImpl();
        //dao 注入dao
        // as.setMapper(注入代理的mapper接口实现类);
        return as;
    }
}
