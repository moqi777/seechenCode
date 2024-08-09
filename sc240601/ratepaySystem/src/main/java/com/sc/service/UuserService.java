package com.sc.service;

import com.sc.pojo.Uuser;
import com.sc.util.PageUtil;

public interface UuserService {
    Object login(String name,String pwd);
    PageUtil<Uuser> showAllUuserLimli(int currentIndex,int pageSize);
}
