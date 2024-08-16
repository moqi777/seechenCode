package com.ssm.mapper;

import com.ssm.pojo.OArticle;

public interface OArticleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OArticle record);

    int insertSelective(OArticle record);

    OArticle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OArticle record);

    int updateByPrimaryKey(OArticle record);
}