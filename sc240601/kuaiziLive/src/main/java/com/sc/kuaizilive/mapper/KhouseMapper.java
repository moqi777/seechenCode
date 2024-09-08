package com.sc.kuaizilive.mapper;

import com.sc.kuaizilive.pojo.Khouse;
import org.springframework.stereotype.Repository;

@Repository
public interface KhouseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Khouse record);

    int insertSelective(Khouse record);

    Khouse selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Khouse record);

    int updateByPrimaryKey(Khouse record);
}