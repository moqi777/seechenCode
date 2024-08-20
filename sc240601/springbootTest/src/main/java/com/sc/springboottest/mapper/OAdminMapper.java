package com.sc.springboottest.mapper;

import com.sc.springboottest.pojo.OAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface OAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OAdmin record);

    int insertSelective(OAdmin record);

    OAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OAdmin record);

    int updateByPrimaryKey(OAdmin record);

    OAdmin login(OAdmin admin);
}