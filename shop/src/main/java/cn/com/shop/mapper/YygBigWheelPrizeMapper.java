package cn.com.shop.mapper;

import cn.com.shop.entity.YygBigWheelPrize;

public interface YygBigWheelPrizeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygBigWheelPrize record);

    int insertSelective(YygBigWheelPrize record);

    YygBigWheelPrize selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygBigWheelPrize record);

    int updateByPrimaryKey(YygBigWheelPrize record);
}