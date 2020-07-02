package cn.com.shop.mapper;

import cn.com.shop.entity.YygBigWheel;

public interface YygBigWheelMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygBigWheel record);

    int insertSelective(YygBigWheel record);

    YygBigWheel selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygBigWheel record);

    int updateByPrimaryKeyWithBLOBs(YygBigWheel record);

    int updateByPrimaryKey(YygBigWheel record);
}