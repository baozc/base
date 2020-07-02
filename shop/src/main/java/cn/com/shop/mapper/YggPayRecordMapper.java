package cn.com.shop.mapper;

import cn.com.shop.entity.YggPayRecord;

public interface YggPayRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YggPayRecord record);

    int insertSelective(YggPayRecord record);

    YggPayRecord selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YggPayRecord record);

    int updateByPrimaryKey(YggPayRecord record);
}