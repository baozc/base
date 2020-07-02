package cn.com.shop.mapper;

import cn.com.shop.entity.YggCashAddress;

public interface YggCashAddressMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YggCashAddress record);

    int insertSelective(YggCashAddress record);

    YggCashAddress selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YggCashAddress record);

    int updateByPrimaryKey(YggCashAddress record);
}