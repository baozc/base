package cn.com.shop.mapper;

import cn.com.shop.entity.YygYgOrder;

public interface YygYgOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygYgOrder record);

    int insertSelective(YygYgOrder record);

    YygYgOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygYgOrder record);

    int updateByPrimaryKey(YygYgOrder record);
}