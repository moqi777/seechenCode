package com.ssm.mapper;

import com.ssm.pojo.ORole;

public interface ORoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ORole record);

    int insertSelective(ORole record);

    ORole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ORole record);

    int updateByPrimaryKey(ORole record);
}