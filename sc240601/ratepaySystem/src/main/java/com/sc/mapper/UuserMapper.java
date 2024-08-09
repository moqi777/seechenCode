package com.sc.mapper;

import com.sc.pojo.Uuser;

public interface UuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Uuser record);

    int insertSelective(Uuser record);

    Uuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uuser record);

    int updateByPrimaryKey(Uuser record);
}