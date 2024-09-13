package com.sc.stock.controller;

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
    public Result reduce(){
        System.out.println("减少库存");
        return new Result(1,"减少库存成功："+port);
    }
}
