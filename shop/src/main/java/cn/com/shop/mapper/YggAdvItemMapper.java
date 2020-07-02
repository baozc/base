package cn.com.shop.mapper;

import cn.com.shop.entity.YggAdvItem;

public interface YggAdvItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YggAdvItem record);

    int insertSelective(YggAdvItem record);

    YggAdvItem selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YggAdvItem record);

    int updateByPrimaryKey(YggAdvItem record);
}