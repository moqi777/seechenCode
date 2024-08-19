package com.springboot.springboot.mapper;

import com.github.pagehelper.PageInfo;
import com.springboot.springboot.pojo.OAdmin;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OAdminMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OAdmin record);

    int insertSelective(OAdmin record);

    OAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OAdmin record);

    int updateByPrimaryKey(OAdmin record);

    OAdmin login(OAdmin a);

    List<OAdmin> show();
}