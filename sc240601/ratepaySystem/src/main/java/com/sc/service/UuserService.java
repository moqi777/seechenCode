package com.sc.service;

import com.github.pagehelper.PageInfo;
import com.sc.pojo.Uuser;

public interface UuserService {
    Object login(String name,String pwd);
    PageInfo<Uuser> showAllUuserLimli(String nameOrAccount, Integer currentIndex, Integer pageSize);
    void delbyIds(Integer[] ids);
}
