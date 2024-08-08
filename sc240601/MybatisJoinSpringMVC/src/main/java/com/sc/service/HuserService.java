package com.sc.service;

import com.sc.pojo.Huser;

import java.util.List;

public interface HuserService {
    List<Huser> selectAll();
    int insertHuser(Huser huser);
    void delHuserByIds(int[] ids);
}
