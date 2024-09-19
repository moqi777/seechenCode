package com.sc.order.feign;

import com.sc.order.config.OpenFeignConfig;
import com.sc.order.pojo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//进程远程调用的业务 (name="服务名")
//如果调用的服务 宕机了 还可以提供 请求回调 返回自定义的错误信息
@FeignClient(name = "goods-service",configuration = OpenFeignConfig.class)
public interface GoodsFeignService {
    //指定调用服务的请求 写法要跟调用的服务 控制层一模一样
    //不用写方法实现：远程调用的服务帮我们实现 OpenFeign根据实现动态生成实现类
    @GetMapping("/getGoods/{id}")
    public Result getGoods(@PathVariable("id") Integer id);
}
