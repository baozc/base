package cn.com.shop.mapper;

import cn.com.shop.entity.YygArticles;

public interface YygArticlesMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygArticles record);

    int insertSelective(YygArticles record);

    YygArticles selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygArticles record);

    int updateByPrimaryKeyWithBLOBs(YygArticles record);

    int updateByPrimaryKey(YygArticles record);
}