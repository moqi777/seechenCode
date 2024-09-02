package com.sv.springbootvue.mapper;

import com.sv.springbootvue.pojo.OAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface OAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OAdmin record);

    int insertSelective(OAdmin record);

    OAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OAdmin record);

    OAdmin login(OAdmin admin);
}