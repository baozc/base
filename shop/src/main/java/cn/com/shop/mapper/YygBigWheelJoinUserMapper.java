package cn.com.shop.mapper;

import cn.com.shop.entity.YygBigWheelJoinUser;

public interface YygBigWheelJoinUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygBigWheelJoinUser record);

    int insertSelective(YygBigWheelJoinUser record);

    YygBigWheelJoinUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygBigWheelJoinUser record);

    int updateByPrimaryKey(YygBigWheelJoinUser record);
}