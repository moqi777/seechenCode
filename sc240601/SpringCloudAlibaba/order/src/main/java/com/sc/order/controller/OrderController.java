package com.sc.order.controller;

import com.sc.order.feign.GoodsFeignService;
import com.sc.order.feign.StockFeignService;
import com.sc.order.pojo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/13 15:09
 **/
@RestController
public class OrderController {
    // @Autowired
    // RestTemplate rt;
    @Autowired
    GoodsFeignService gs;
    @Autowired
    StockFeignService ss;
    @RequestMapping("/add")
    public Result add(Integer id){
        System.out.println("下单成功,id:"+id);
        //自己先执行自己下单业务
        //调用库存服务 减少库存
        //rt.getForObject("其他服务地址",响应结果类型) 进程远程调用
        //也可以实现调用第三方接口 地址 比如：短信接口 支付接口 天气接口
        //Result stockResult = rt.getForObject("http://stock-service/reduce", Result.class);
        //远程调用商品服务：通过openFeign调用
        Result goodsResult = gs.getGoods(id);
        //远程调用库存服务：通过openFeign调用
        Result stockResult = ss.reduce();
        return new Result(1,"下单成功,"+stockResult.getMsg()+"，商品："+goodsResult.getMsg());
    }
    @RequestMapping("/cancel")
    public Result cancel(){
        Result stockResult = ss.add();
        return new Result(1,"取消订单，"+stockResult.getMsg());
    }
}
