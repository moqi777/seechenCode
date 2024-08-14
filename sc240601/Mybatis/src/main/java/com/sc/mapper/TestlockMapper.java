package com.sc.mapper;

import com.sc.pojo.Testlock;

public interface TestlockMapper {
    int deleteByPrimaryKey(Integer id);
    int insert(Testlock record);
    int insertSelective(Testlock record);
    Testlock selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Testlock record);
    int updateByPrimaryKey(Testlock record);

    //实现乐观锁 更新
    int updateLock(Testlock lock);
    //实现悲观锁 查询 添加for update给数据上锁
    Testlock selectForUpdate(Integer id);
}