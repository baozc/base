package cn.com.shop.mapper;

import cn.com.shop.entity.YygBanner;

public interface YygBannerMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygBanner record);

    int insertSelective(YygBanner record);

    YygBanner selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygBanner record);

    int updateByPrimaryKey(YygBanner record);
}