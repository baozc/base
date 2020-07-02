package cn.com.shop.mapper;

import cn.com.shop.entity.YygArticlesCate;

public interface YygArticlesCateMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygArticlesCate record);

    int insertSelective(YygArticlesCate record);

    YygArticlesCate selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygArticlesCate record);

    int updateByPrimaryKeyWithBLOBs(YygArticlesCate record);

    int updateByPrimaryKey(YygArticlesCate record);
}