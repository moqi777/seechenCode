package com.sc.springboottest.mapper;

import com.sc.springboottest.pojo.Emp;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpMapper {
    int deleteByPrimaryKey(Integer empno);

    int insert(Emp record);

    int insertSelective(Emp record);

    Emp selectByPrimaryKey(Integer empno);

    int updateByPrimaryKeySelective(Emp record);

    int updateByPrimaryKey(Emp record);

    List<Emp> selectAll();
}