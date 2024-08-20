package com.sc.springboottest.server;

import com.sc.springboottest.pojo.OAdmin;

public interface AdminService {
    OAdmin login(OAdmin admin);
    OAdmin showById(Integer id);
    int delById(Integer id);
}
