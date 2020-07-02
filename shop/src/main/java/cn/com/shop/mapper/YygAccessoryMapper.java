package cn.com.shop.mapper;

import cn.com.shop.entity.YygAccessory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface YygAccessoryMapper extends BaseMapper<YygAccessory> {
    int deleteByPrimaryKey(Long id);

    int insert(YygAccessory record);

    int insertSelective(YygAccessory record);

    YygAccessory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygAccessory record);

    int updateByPrimaryKey(YygAccessory record);
}