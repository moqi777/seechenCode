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
}