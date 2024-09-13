package com.sc.order.controller;

import com.sc.order.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/13 15:09
 **/
@RestController
public class OrderController {
    @Autowired
    RestTemplate rt;
    @RequestMapping("/add")
    public Result add(){
        System.out.println("下单成功");
        //自己先执行自己下单业务
        //调用库存服务 减少库存
        //rt.getForObject("其他服务地址",响应结果类型) 进程远程调用
        //也可以实现调用第三方接口 地址 比如：短信接口 支付接口 天气接口
        Result stockResult = rt.getForObject("http://stock-service/reduce", Result.class);
        return new Result(1,"下单成功,"+stockResult.getMsg());
    }
}
