package com.sc.dao;

import com.sc.pojo.Mybatis_emp;
import org.apache.ibatis.annotations.Param;

public interface Mybatis_empMapper {
    public int add(Mybatis_emp mybatis_emp);
    public int del(int id);
    public int addMoney(@Param("id") int id,@Param("money") double money);
}
