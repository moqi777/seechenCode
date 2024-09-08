package com.sc.kuaizilive.mapper;

import com.sc.kuaizilive.pojo.KhouseContact;
import org.springframework.stereotype.Repository;

@Repository
public interface KhouseContactMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KhouseContact record);

    int insertSelective(KhouseContact record);

    KhouseContact selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KhouseContact record);

    int updateByPrimaryKey(KhouseContact record);
}