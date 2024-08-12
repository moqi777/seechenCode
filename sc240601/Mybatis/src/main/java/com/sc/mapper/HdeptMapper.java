package com.sc.mapper;

import com.sc.pojo.Hdept;

import java.util.List;

public interface HdeptMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hdept record);

    int insertSelective(Hdept record);

    Hdept selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hdept record);

    int updateByPrimaryKey(Hdept record);

    //1:n
    List<Hdept> selectAll();
    List<Hdept> selectAll2();
}