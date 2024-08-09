package com.sc.service.impl;

import com.sc.dao.UuserDao;
import com.sc.dao.impl.UuserDaoimpl;
import com.sc.pojo.Uuser;
import com.sc.service.UuserService;
import com.sc.util.PageUtil;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/5 20:47
 **/
public class UuserServiceImpl implements UuserService {
    UuserDao uuserDao = new UuserDaoimpl();
    public Object login(String name, String pwd) {
        //根据账号查询到用户信息
        Uuser uuser = uuserDao.selectToAccount(name);
        //判断该用户 是否存在 如果不存在返回错误信息
        if (uuser==null) return "用户不存在";
        if (!uuser.getPassword().equals(pwd)) return "密码错误";
        return uuser;
    }

    @Override
    public PageUtil<Uuser> showAllUuserLimli(int currentIndex, int pageSize) {
        PageUtil<Uuser> pageUtil = new PageUtil<>();
        pageUtil.setCurrentIndex(currentIndex);
        pageUtil.setPageSize(pageSize);
        //查询数据库总条数
        int count = uuserDao.selectUuserCount();
        pageUtil.setTotalCount(count);
        List<Uuser> list = uuserDao.selectUuserLimit(pageUtil);
        pageUtil.setList(list);
        return pageUtil;
    }
}
