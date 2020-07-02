package cn.com.shop.mapper;

import cn.com.shop.entity.YygStoreAccountDetail;

public interface YygStoreAccountDetailMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygStoreAccountDetail record);

    int insertSelective(YygStoreAccountDetail record);

    YygStoreAccountDetail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygStoreAccountDetail record);

    int updateByPrimaryKey(YygStoreAccountDetail record);
}