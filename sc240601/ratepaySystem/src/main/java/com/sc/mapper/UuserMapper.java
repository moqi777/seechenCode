package com.sc.mapper;

import com.sc.pojo.Uuser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Uuser record);

    int insertSelective(Uuser record);

    Uuser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Uuser record);

    int updateByPrimaryKey(Uuser record);

    Uuser selectByAccount(String account);

    List<Uuser> selectByAccountOrNameLimit(@Param("nameOrAccount") String nameOrAccount);

    int delByIds(Integer[] ids);
}