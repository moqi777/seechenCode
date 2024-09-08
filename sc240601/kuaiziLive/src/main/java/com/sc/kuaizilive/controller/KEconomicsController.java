package com.sc.kuaizilive.controller;

import com.sc.kuaizilive.pojo.KEconomics;
import com.sc.kuaizilive.pojo.Result;
import com.sc.kuaizilive.server.KEconomicsServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/keconomics")
public class KEconomicsController {
    @Autowired
    KEconomicsServe es;
    //新增家政订单
    @RequestMapping("/economics")
    public Result InsertEconomics(@RequestBody KEconomics ke){
        return es.InsertEconomics(ke);
    }
}
