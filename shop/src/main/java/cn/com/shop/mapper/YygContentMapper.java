package cn.com.shop.mapper;

import cn.com.shop.entity.YygContent;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface YygContentMapper extends BaseMapper<YygContent> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(YygContent record);

    int insertSelective(YygContent record);

    YygContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygContent record);

    int updateByPrimaryKeyWithBLOBs(YygContent record);

    int updateByPrimaryKey(YygContent record);
}