package cn.com.shop.mapper;

import cn.com.shop.entity.YygYgProduct;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface YygYgProductMapper extends BaseMapper<YygYgProduct> {
    int deleteByPrimaryKey(Long id);

    int insert(YygYgProduct record);

    int insertSelective(YygYgProduct record);

    YygYgProduct selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygYgProduct record);

    int updateByPrimaryKeyWithBLOBs(YygYgProduct record);

    int updateByPrimaryKey(YygYgProduct record);
}