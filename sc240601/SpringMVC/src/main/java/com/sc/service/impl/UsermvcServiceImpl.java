package com.sc.service.impl;

import com.sc.dao.impl.UsermvcDaoImpl;
import com.sc.pojo.Usermvc;
import com.sc.service.UsermvcService;
import com.sc.util.PageInfo;

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

    public PageInfo<Usermvc> show(int currentIndex, int pageSize) {
        PageInfo<Usermvc> p = new PageInfo<>();
        p.setCurrentIndex(currentIndex);
        p.setPageSize(pageSize);
        p.setTotalCount(ud.Count());//set方法内部计算好总页数
        p.setList(ud.show(currentIndex,pageSize));
        return p;
    }
}
