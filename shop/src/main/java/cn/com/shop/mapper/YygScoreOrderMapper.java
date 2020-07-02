package cn.com.shop.mapper;

import cn.com.shop.entity.YygScoreOrder;

public interface YygScoreOrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygScoreOrder record);

    int insertSelective(YygScoreOrder record);

    YygScoreOrder selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygScoreOrder record);

    int updateByPrimaryKey(YygScoreOrder record);
}