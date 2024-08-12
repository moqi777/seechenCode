package com.ms.service;

import com.ms.pojo.Huser;

import java.util.List;

public interface HuserService {
    List<Huser> selectAll();
    int insertHuser(Huser huser);
    void delHuserByIds(int[] ids);
}
