package com.sc.kuaizilive.mapper;

import com.sc.kuaizilive.pojo.KEconomics;
import org.springframework.stereotype.Repository;
@Repository
public interface KEconomicsMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KEconomics record);

    int insertSelective(KEconomics record);

    KEconomics selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(KEconomics record);

    int updateByPrimaryKeyWithBLOBs(KEconomics record);

    int updateByPrimaryKey(KEconomics record);

}