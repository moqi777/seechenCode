package com.ssm.mapper;

import com.ssm.pojo.OMenu;

public interface OMenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OMenu record);

    int insertSelective(OMenu record);

    OMenu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OMenu record);

    int updateByPrimaryKey(OMenu record);
}