package com.sv.springbootvue.mapper;

import com.sv.springbootvue.pojo.Myuser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MyuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Myuser record);

    int insertSelective(Myuser record);

    Myuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Myuser record);

    int updateByPrimaryKey(Myuser record);

    List<Myuser> selectLimit(Myuser myuser);
}