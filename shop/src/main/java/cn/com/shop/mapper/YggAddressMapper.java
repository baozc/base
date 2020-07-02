package cn.com.shop.mapper;

import cn.com.shop.entity.YggAddress;
import cn.com.shop.entity.YggAddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface YggAddressMapper {
    long countByExample(YggAddressExample example);

    int deleteByExample(YggAddressExample example);

    int deleteByPrimaryKey(Long id);

    int insert(YggAddress record);

    int insertSelective(YggAddress record);

    List<YggAddress> selectByExample(YggAddressExample example);

    YggAddress selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") YggAddress record, @Param("example") YggAddressExample example);

    int updateByExample(@Param("record") YggAddress record, @Param("example") YggAddressExample example);

    int updateByPrimaryKeySelective(YggAddress record);

    int updateByPrimaryKey(YggAddress record);
}