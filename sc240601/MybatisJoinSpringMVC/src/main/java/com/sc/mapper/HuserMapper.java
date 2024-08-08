package com.sc.mapper;

import com.sc.pojo.Huser;

import java.util.List;

public interface HuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huser record);

    int insertSelective(Huser record);

    Huser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huser record);

    int updateByPrimaryKey(Huser record);

    List<Huser> selectAll();
}