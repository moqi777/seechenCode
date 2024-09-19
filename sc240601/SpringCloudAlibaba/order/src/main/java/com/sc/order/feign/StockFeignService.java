package com.sc.order.feign;

import com.sc.order.feign.impl.StockFeiginServiceImpl;
import com.sc.order.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
//fallback表示如果服务出现异常了 直接返回这个服务接口的实现类
@FeignClient(name = "stock-service",fallback = StockFeiginServiceImpl.class)
public interface StockFeignService {
    //宕机了怎么办？
    @RequestMapping("/reduce")
    public Result reduce();
    @RequestMapping("/add")
    public Result add();
}
