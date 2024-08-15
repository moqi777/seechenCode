package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:统计 每个业务层方法运行的时间   如果运行报错 显示运行的出现的异常信息
 * @DateTime:2024/8/15 19:40
 **/
@Component
@Aspect
public class ServiceTimeLog {
    @Pointcut("execution(* com.spring.service.impl.*.*(..))")
    public void pc(){}

    @Around("pc()")
    public Object all(ProceedingJoinPoint jp){
        String name = jp.getSignature().getName();
        Object proceed = null;
        long time = new Date().getTime();
        try {
            System.out.println("方法："+name+"开始执行");
             proceed = jp.proceed();
        } catch (Throwable e) {
            System.out.println("方法："+name+"执行错误："+e);
        }finally {
            long time1 = new Date().getTime();
            System.out.println("方法："+name+"执行完毕，所用"+(time1-time)+"毫秒");
        }
        return proceed;
    }
}
