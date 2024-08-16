package com.ssm.mapper;

import com.ssm.pojo.OLog;

public interface OLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OLog record);

    int insertSelective(OLog record);

    OLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OLog record);

    int updateByPrimaryKey(OLog record);
}