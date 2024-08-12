package com.ms.service.impl;

import com.ms.mapper.HuserinfoMapper;
import com.ms.pojo.Huserinfo;
import com.ms.service.HuserService;
import com.ms.mapper.HuserMapper;
import com.ms.pojo.Huser;
import com.ms.util.MybatisUtil;

import java.util.List;

/**
 * @author:zhengYiLong
 * @email:1797344574@qq.com
 * @phone:13479394730
 * @desc:
 * @DateTime:2024/8/8 20:14
 **/
public class HuserServiceImpl implements HuserService {
    public List<Huser> selectAll() {
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        List<Huser> list = mapper.selectAll();
        MybatisUtil.close();
        return list;
    }

    public int insertHuser(Huser huser) {
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        int i = mapper.insertSelective(huser);
        MybatisUtil.close();
        HuserinfoMapper mapper2 = MybatisUtil.getMapper(HuserinfoMapper.class);
        //把执行插入操作后数据库返回的自增ID给到info使用
        huser.getInfo().setId(huser.getId());
        mapper2.insertSelective(huser.getInfo());
        MybatisUtil.close();
        return i;
    }

    public void delHuserByIds(int[] ids) {
        HuserMapper mapper = MybatisUtil.getMapper(HuserMapper.class);
        for (int id : ids) {
            mapper.deleteByPrimaryKey(id);
        }
        MybatisUtil.close();
        return;
    }


}
