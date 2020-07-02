package cn.com.shop.mapper;

import cn.com.shop.entity.YygBrand;

public interface YygBrandMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygBrand record);

    int insertSelective(YygBrand record);

    YygBrand selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygBrand record);

    int updateByPrimaryKey(YygBrand record);
}