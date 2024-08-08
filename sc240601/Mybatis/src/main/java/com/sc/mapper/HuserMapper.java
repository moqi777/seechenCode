package com.sc.mapper;

import com.sc.pojo.Huser;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HuserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Huser record);

    int insertSelective(Huser record);

    Huser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Huser record);

    int updateByPrimaryKey(Huser record);

    List<Huser> selectByUsername(String username);

    //为了测试多个参数 带对象参数
    int addUser1(@Param("username") String username,@Param("password") String password);
    int addUser2(@Param("un") String username,@Param("user") Huser u,@Param("date") Date time);

    //传递集合或数组
    int batchAdd(List<Huser> users);
    int batchDel(Integer[] ids);

    //传递Map集合
    List<Huser> selectByMap(Map m);
}