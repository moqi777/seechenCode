package com.sc.sentinel.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sc.sentinel.pojo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/18 17:05
 **/
@RestController
public class SentinelController {
    @RequestMapping("/testQPS")
    //value：定义资源(就是请求)
    //blockHandler：设置流量规则后处理的方法(默认该方法必须声明在同一个类中)
    //fallback：当接口出现异常 就可以交给回调函数指定方法来执行
    @SentinelResource(value = "/test",blockHandler = "QPSHandler")
    public Result testQPS(){
        return new Result(1,"成功");
    }

    @RequestMapping("/testThread")
    @SentinelResource(value = "testThread",blockHandler = "ThreadHandler")
    public Result testThread() throws InterruptedException {
        //调用其他服务 调用服务器...
        Thread.sleep(5000); //模拟处理请求时长
        return new Result(1,"请求成功");
    }

    //测试慢调用
    @RequestMapping("/testSlow")
    @SentinelResource(value = "testSlow",blockHandler = "slowHandler")
    public Result testSlow() throws InterruptedException {
        //一会设置规则 最大RT(设置2秒) 这样每次请求超过2秒都是慢调用
        Thread.sleep(3000);
        return new Result(1,"慢调用访问成功");
    }

    //流控方法要求：
    //1.一定要public
    //2.方法返回值和原方法一致的
    //3.可选：参数最后一个位置 BlackException用来区分什么规则异常
    public Result QPSHandler(BlockException e){
        return new Result(0,"操作频繁");
    }
    public Result ThreadHandler(BlockException e){
        return new Result(0,"网络延迟");
    }
    public Result slowHandler(BlockException e){
        return new Result(0,"你被熔断了");
    }
}
