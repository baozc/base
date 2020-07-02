package cn.com.shop.mapper;

import cn.com.shop.entity.YygSysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface YygSysDictMapper extends BaseMapper<YygSysDict> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(YygSysDict record);

    int insertSelective(YygSysDict record);

    YygSysDict selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygSysDict record);

    int updateByPrimaryKey(YygSysDict record);
}