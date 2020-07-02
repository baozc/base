package cn.com.shop.mapper;

import cn.com.shop.entity.YygArea;

public interface YygAreaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygArea record);

    int insertSelective(YygArea record);

    YygArea selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygArea record);

    int updateByPrimaryKey(YygArea record);
}