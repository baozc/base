package cn.com.shop.mapper;

import cn.com.shop.entity.YygSysConfig;

public interface YygSysConfigMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygSysConfig record);

    int insertSelective(YygSysConfig record);

    YygSysConfig selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygSysConfig record);

    int updateByPrimaryKeyWithBLOBs(YygSysConfig record);

    int updateByPrimaryKey(YygSysConfig record);
}