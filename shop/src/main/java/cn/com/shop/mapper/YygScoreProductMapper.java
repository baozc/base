package cn.com.shop.mapper;

import cn.com.shop.entity.YygScoreProduct;

public interface YygScoreProductMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygScoreProduct record);

    int insertSelective(YygScoreProduct record);

    YygScoreProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygScoreProduct record);

    int updateByPrimaryKey(YygScoreProduct record);
}