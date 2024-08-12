package com.sc.mapper;

import com.sc.pojo.Sstudent;

public interface SstudentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sstudent record);

    int insertSelective(Sstudent record);

    Sstudent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sstudent record);

    int updateByPrimaryKey(Sstudent record);

    Sstudent selectById(Integer id);
    Sstudent selectById2(Integer id);
}