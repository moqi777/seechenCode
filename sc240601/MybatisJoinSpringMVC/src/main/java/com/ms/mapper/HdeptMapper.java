package com.ms.mapper;

import com.ms.pojo.Hdept;

public interface HdeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hdept record);

    int insertSelective(Hdept record);

    Hdept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hdept record);

    int updateByPrimaryKey(Hdept record);
}