package com.sc.kuaizilive.mapper;

import com.sc.kuaizilive.pojo.KhouseImg;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KhouseImgMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KhouseImg record);

    int insertSelective(KhouseImg record);

    KhouseImg selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KhouseImg record);

    int updateByPrimaryKey(KhouseImg record);

    int inserts(@Param("imgs") List<String> imgs,@Param("property_id") int property_id);
}