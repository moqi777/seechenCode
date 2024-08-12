package com.sc.mapper;

import com.sc.pojo.Huserinfo;

public interface HuserinfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huserinfo record);

    int insertSelective(Huserinfo record);

    Huserinfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huserinfo record);

    int updateByPrimaryKey(Huserinfo record);
}