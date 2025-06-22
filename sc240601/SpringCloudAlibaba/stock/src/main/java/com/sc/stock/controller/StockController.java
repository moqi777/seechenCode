package com.sc.stock.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sc.stock.pojo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/13 16:04
 **/
@RestController
public class StockController {
    @Value("${server.port}")
    int port;
    @RequestMapping("/reduce")
    @SentinelResource(value = "reduce",blockHandler = "QPSHandler")
    public Result reduce() throws InterruptedException {
        System.out.println("减少库存");
        // int i = 10/0;//模拟异常 对方会进行回调
        //订单服务设置最大时间 5S  会超时 会出现异常
        // Thread.sleep(6000);
        return new Result(1,"减少库存成功："+port);
    }
    @RequestMapping("/add")
    @SentinelResource(value = "add",blockHandler = "ThreadHandler")
    public Result add() throws InterruptedException {
        System.out.println("增加库存");
        Thread.sleep(5000);
        return new Result(1,"增加库存成功："+port);
    }
    
    public Result QPSHandler(BlockException e){
        return new Result(0,"每秒请求数2次，你被限流了，稍后使用");
    }
    public Result ThreadHandler(BlockException e){
        return new Result(0,"并发线程数是1，你被流控了，稍后使用");
    }
}
