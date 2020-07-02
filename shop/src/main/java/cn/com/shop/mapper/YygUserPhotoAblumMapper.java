package cn.com.shop.mapper;

import cn.com.shop.entity.YygUserPhotoAblum;

public interface YygUserPhotoAblumMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygUserPhotoAblum record);

    int insertSelective(YygUserPhotoAblum record);

    YygUserPhotoAblum selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygUserPhotoAblum record);

    int updateByPrimaryKey(YygUserPhotoAblum record);
}