package com.ssm.mapper;

import com.ssm.pojo.OCategory;

public interface OCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OCategory record);

    int insertSelective(OCategory record);

    OCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OCategory record);

    int updateByPrimaryKey(OCategory record);
}