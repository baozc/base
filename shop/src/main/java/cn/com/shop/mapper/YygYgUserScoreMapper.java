package cn.com.shop.mapper;

import cn.com.shop.entity.YygYgUserScore;

public interface YygYgUserScoreMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygYgUserScore record);

    int insertSelective(YygYgUserScore record);

    YygYgUserScore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygYgUserScore record);

    int updateByPrimaryKey(YygYgUserScore record);
}