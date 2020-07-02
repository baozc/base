package cn.com.shop.mapper;

import cn.com.shop.entity.YygExpressCom;

public interface YygExpressComMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygExpressCom record);

    int insertSelective(YygExpressCom record);

    YygExpressCom selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygExpressCom record);

    int updateByPrimaryKey(YygExpressCom record);
}