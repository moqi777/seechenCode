package com.sc.kuaizilive.mapper;

import com.sc.kuaizilive.pojo.KhouseProperty;
import org.springframework.stereotype.Repository;

@Repository
public interface KhousePropertyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KhouseProperty record);

    int insertSelective(KhouseProperty record);

    KhouseProperty selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KhouseProperty record);

    int updateByPrimaryKey(KhouseProperty record);
}