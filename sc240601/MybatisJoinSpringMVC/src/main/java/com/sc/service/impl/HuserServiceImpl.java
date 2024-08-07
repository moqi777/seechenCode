package com.sc.service.impl;

import com.sc.dao.HuserMapper;
import com.sc.pojo.Huser;
import com.sc.service.HuserService;
import com.sc.util.MybatisUtil;

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
