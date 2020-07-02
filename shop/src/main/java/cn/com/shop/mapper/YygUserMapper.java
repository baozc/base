package cn.com.shop.mapper;

import cn.com.shop.entity.YygUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface YygUserMapper extends BaseMapper<YygUser> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(YygUser record);

    int insertSelective(YygUser record);

    YygUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygUser record);

    int updateByPrimaryKeyWithBLOBs(YygUser record);

    int updateByPrimaryKey(YygUser record);
}