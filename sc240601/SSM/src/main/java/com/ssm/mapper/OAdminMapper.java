package com.ssm.mapper;

import com.ssm.pojo.OAdmin;

import java.util.List;

public interface OAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OAdmin record);

    int insertSelective(OAdmin record);

    OAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OAdmin record);

    int updateByPrimaryKey(OAdmin record);

    OAdmin login(OAdmin admin);

    List<OAdmin> show(OAdmin admin);

    int selectByAccount(String account);
    //根据id删除用户
    int deleteByIds(Integer[] ids);
    //根据id将用户状态设置为启用1
    int startUsingByIds(Integer[] ids);
    //根基id将用户状态设置为禁用2
    int disableByIds(Integer[] ids);
}