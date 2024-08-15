package com.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/15 14:58
 **/
//AOP实现日志功能，让所有业务层方法执行的时候 可以添加日志
//日志切面
public class MyLog {
    public void aa(){
        System.out.println("我是前置通知");
    }
    public void bb(Object result){
        System.out.println("我是后置通知，参数表示目标方法返回值");
    }
    public void cc(Exception e){
        System.out.println("我是异常通知，参数表示目标方法发生的异常");
    }
    public void dd(){
        System.out.println("我是最后通知");
    }
    //配置环绕通知方法
    public Object ee(ProceedingJoinPoint jp){
        Object result = null;
        try {
            System.out.println("前置");
            result = jp.proceed();//等价于jdk动态代理invoke() 表示目标方法的调用
            System.out.println("后置");
        } catch (Throwable e) {
            System.out.println("异常");
        }finally {
            System.out.println("最后");
        }
        return result;
    }
}
