package com.sc.service.impl;

import com.sc.dao.impl.UsermvcDaoImpl;
import com.sc.pojo.Usermvc;
import com.sc.service.UsermvcService;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/1 17:01
 **/
public class UsermvcServiceImpl implements UsermvcService {
    UsermvcDaoImpl ud = new UsermvcDaoImpl();
    public int add(Usermvc u) {
        return ud.add(u);
    }

    public List<Usermvc> show() {
        return ud.show();
    }
}
