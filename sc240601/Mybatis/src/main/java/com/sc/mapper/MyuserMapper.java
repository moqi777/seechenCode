package com.sc.mapper;

import com.sc.pojo.Myuser;

import java.util.List;

public interface MyuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Myuser record);

    int insertSelective(Myuser record);

    Myuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Myuser record);

    int updateByPrimaryKey(Myuser record);

    List<Myuser> show();
}