package cn.com.shop.mapper;

import cn.com.shop.entity.YygScoreApply;

public interface YygScoreApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygScoreApply record);

    int insertSelective(YygScoreApply record);

    YygScoreApply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygScoreApply record);

    int updateByPrimaryKey(YygScoreApply record);
}