package cn.com.shop.mapper;

import cn.com.shop.entity.YygProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface YygProductMapper extends BaseMapper<YygProduct> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(YygProduct record);

    int insertSelective(YygProduct record);

    YygProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygProduct record);

    int updateByPrimaryKey(YygProduct record);
}