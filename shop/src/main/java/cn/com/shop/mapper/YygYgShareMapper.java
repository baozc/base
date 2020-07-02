package cn.com.shop.mapper;

import cn.com.shop.entity.YygYgShare;

public interface YygYgShareMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygYgShare record);

    int insertSelective(YygYgShare record);

    YygYgShare selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygYgShare record);

    int updateByPrimaryKey(YygYgShare record);
}