package com.sc.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.mapper.UuserMapper;
import com.sc.pojo.Uuser;
import com.sc.service.UuserService;
import com.sc.util.MybatisUtil;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/5 20:47
 **/
public class UuserServiceImpl implements UuserService {
    public Object login(String name, String pwd) {
        //根据账号查询到用户信息
        UuserMapper mapper = MybatisUtil.getMapper(UuserMapper.class);
        Uuser uuser = mapper.selectByAccount(name);
        MybatisUtil.close();
        //判断该用户 是否存在 如果不存在返回错误信息
        if (uuser==null) return "用户不存在";
        if (!uuser.getPassword().equals(pwd)) return "密码错误";
        return uuser;
    }

    @Override
    public void delbyIds(Integer[] ids) {
        UuserMapper mapper = MybatisUtil.getMapper(UuserMapper.class);
        mapper.delByIds(ids);
        MybatisUtil.close();
    }

    @Override
    public PageInfo<Uuser> showAllUuserLimli(String nameOrAccount,Integer currentIndex,Integer pageSize) {
        PageHelper.startPage(currentIndex,pageSize);
        UuserMapper mapper = MybatisUtil.getMapper(UuserMapper.class);
        List<Uuser> list = mapper.selectByAccountOrNameLimit(nameOrAccount);
        MybatisUtil.close();
        return new PageInfo<Uuser>(list);
    }
}
