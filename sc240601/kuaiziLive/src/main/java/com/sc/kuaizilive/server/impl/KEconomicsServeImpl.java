package com.sc.kuaizilive.server.impl;

import com.sc.kuaizilive.mapper.KEconomicsMapper;
import com.sc.kuaizilive.pojo.KEconomics;
import com.sc.kuaizilive.pojo.Result;
import com.sc.kuaizilive.server.KEconomicsServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class KEconomicsServeImpl implements KEconomicsServe {
    @Autowired
    KEconomicsMapper mapper2;

    public Result InsertEconomics(KEconomics ke) {
        ke.setCreatedAt(new Date());
        return new Result(mapper2.insertSelective(ke),"申请成功");
    }
}
