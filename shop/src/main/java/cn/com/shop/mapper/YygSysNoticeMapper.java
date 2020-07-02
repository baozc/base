package cn.com.shop.mapper;

import cn.com.shop.entity.YygSysNotice;

public interface YygSysNoticeMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygSysNotice record);

    int insertSelective(YygSysNotice record);

    YygSysNotice selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygSysNotice record);

    int updateByPrimaryKeyWithBLOBs(YygSysNotice record);

    int updateByPrimaryKey(YygSysNotice record);
}