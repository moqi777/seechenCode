package com.sc.order.feign.impl;

import com.sc.order.feign.StockFeignService;
import com.sc.order.pojo.Result;
import org.springframework.stereotype.Component;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/9/19 14:38
 **/
//如果stock服务出现异常了 才会使用该实现类
@Component
public class StockFeiginServiceImpl implements StockFeignService {
    @Override
    public Result reduce() {
        return new Result(0,"减少库存出现问题了");
    }

    @Override
    public Result add() {
        return new Result(0,"添加库存出现问题了");
    }
}
