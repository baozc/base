package cn.com.shop.mapper;

import cn.com.shop.entity.YygUserAccountDetail;

public interface YygUserAccountDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygUserAccountDetail record);

    int insertSelective(YygUserAccountDetail record);

    YygUserAccountDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygUserAccountDetail record);

    int updateByPrimaryKey(YygUserAccountDetail record);
}