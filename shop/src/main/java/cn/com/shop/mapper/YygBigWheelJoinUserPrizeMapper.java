package cn.com.shop.mapper;

import cn.com.shop.entity.YygBigWheelJoinUserPrize;

public interface YygBigWheelJoinUserPrizeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygBigWheelJoinUserPrize record);

    int insertSelective(YygBigWheelJoinUserPrize record);

    YygBigWheelJoinUserPrize selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygBigWheelJoinUserPrize record);

    int updateByPrimaryKey(YygBigWheelJoinUserPrize record);
}