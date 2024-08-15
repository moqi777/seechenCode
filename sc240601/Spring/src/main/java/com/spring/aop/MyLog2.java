package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/15 15:52
 **/
//通过注解来配置AOP日志
//创建MyLog Bean对象
//创建切面 ref引入上面的对象
//切面里面配置很多标签 实现不同通知 关联切入点
//配置切入点
@Component  //通过IOC扫描 等价于编写了bean标签
@Aspect     //标注我是切面 等价于配置Aop:aspect标签
public class MyLog2 {
    //配置切入点注解：等价于 aop:pointcut标签
    @Pointcut("execution(* com.spring.service.impl.*.*(..))")
    public void pc(){}

    @Before("pc()")
    public void before(){
        System.out.println("前置");
    }
    @AfterReturning(pointcut = "pc()",returning = "result")
    public void afterReturning(Object result){
        System.out.println("后置");
    }
    @AfterThrowing(pointcut = "pc()",throwing = "e")
    public void afterThrowing(Exception e){
        System.out.println("异常");
    }
    @After("pc()")
    public void after(){
        System.out.println("最后");
    }
    @Around("pc()")
    public Object around(ProceedingJoinPoint jp){
        Object result = null;
        //获取目标方法的名称
        String methedName = jp.getSignature().getName();
        try {
            Object[] args = jp.getArgs();
            System.out.println(new Date()+"[前置]"+methedName+"开始调用，参数："+ Arrays.toString(args));
            result = jp.proceed();//等价于jdk动态代理invoke() 表示目标方法的调用
            System.out.println(new Date()+"[后置]"+methedName+"运行结束，返回值："+ result);
        } catch (Throwable e) {
            System.out.println(new Date()+"[异常]"+methedName+"运行时发生异常："+e);
        }finally {
            System.out.println(new Date()+"[最后]"+methedName+"运行结束");
        }
        return result;
    }
}
