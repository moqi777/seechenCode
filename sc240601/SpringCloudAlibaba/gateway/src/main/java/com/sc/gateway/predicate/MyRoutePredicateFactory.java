package com.sc.gateway.predicate;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/20 11:45
 **/
@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {
    public MyRoutePredicateFactory(){
        super(MyRoutePredicateFactory.Config.class);
    }

    //定义静态内部类 用于接收 配置文件断言信息
    @Validated
    public static class Config{
        private String name;//但是需要被绑定
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
    //绑定上面内部类中的属性 name
    public List<String> shortcutFieldOrder() {
        //返回值集合存放的就是绑定的属性，里面的值必须和静态内部类属性名一致
        return Arrays.asList("name");
    }
    //重写apply方法 进行判断 验证断言是否通过
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return(server)->{
            //规则可以自己写 -My=admin 才可以匹配断言
            if (config.getName().equals("admin")) return true;
            return false;
        };
    }
}
