package cn.com.shop.mapper;

import cn.com.shop.entity.YggSmsRecord;
import cn.com.shop.entity.YggSmsRecordWithBLOBs;

public interface YggSmsRecordMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YggSmsRecordWithBLOBs record);

    int insertSelective(YggSmsRecordWithBLOBs record);

    YggSmsRecordWithBLOBs selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YggSmsRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(YggSmsRecordWithBLOBs record);

    int updateByPrimaryKey(YggSmsRecord record);
}