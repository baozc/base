package cn.com.shop.mapper;

import cn.com.shop.entity.YygStore;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface YygStoreMapper extends BaseMapper<YygStore> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(YygStore record);

    int insertSelective(YygStore record);

    YygStore selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygStore record);

    int updateByPrimaryKey(YygStore record);
}