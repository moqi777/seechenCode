package com.sc.kuaizilive.mapper;

import com.sc.kuaizilive.pojo.KUser;
import org.springframework.stereotype.Repository;

@Repository
public interface KUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(KUser record);

    int insertSelective(KUser record);

    KUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(KUser record);

    int updateByPrimaryKey(KUser record);

    //根据手机号查询账户
    KUser selectByPhone(String phone);
    //根据用户名查账户
    KUser selectByUserName(String userName);
}