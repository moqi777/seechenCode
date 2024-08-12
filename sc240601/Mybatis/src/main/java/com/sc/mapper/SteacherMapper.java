package com.sc.mapper;

import com.sc.pojo.Steacher;

import java.util.List;

public interface SteacherMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Steacher record);

    int insertSelective(Steacher record);

    Steacher selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Steacher record);

    int updateByPrimaryKey(Steacher record);

    List<Steacher> selectBySid(Integer sid);
}