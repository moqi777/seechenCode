package com.sc.goods.controller;

import com.sc.goods.pojo.Result;
import org.springframework.web.bind.annotation.*;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/14 10:35
 **/
@RestController
public class goodsController {
    //使用RestFul风格 发情请求 推荐同一个资源 只需要发情一个请求即可
    //通过不同的请求方式 来识别你具体要是什么功能
    // @GetMapping("/user")
    // @DeleteMapping("/user/{参数名}")    //  /user/1000
    // public Result test(@PathVariable("参数名") Integer id){}
    // @PostMapping("/user")
    // @PutMapping("/user")

    //之前请求：查询用户 删除用户 新增用户 修改用户
    // @RequestMapping("/queryUser")
    // @RequestMapping("/delUser")
    // @RequestMapping("/addUser")
    // @RequestMapping("/updateUser")

    //getGoods/1000
    @GetMapping("/getGoods/{id}")
    public Result getGoods(@PathVariable("id") Integer id) throws InterruptedException {
        //根据Id调用业务层 mapper层
        System.out.println("查询指定id："+id+"的商品");
        //订单服务设置最大时间10s 没有超时 不会出现异常
        // Thread.sleep(id);
        return new Result(1,"查询商品成功,"+id+"商品");
    }
}
