package cn.com.shop.mapper;

import cn.com.shop.entity.YygUserYg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface YygUserYgMapper extends BaseMapper<YygUserYg> {
    int deleteByPrimaryKey(Long id);

    @Override
    int insert(YygUserYg record);

    int insertSelective(YygUserYg record);

    YygUserYg selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygUserYg record);

    int updateByPrimaryKeyWithBLOBs(YygUserYg record);

    int updateByPrimaryKey(YygUserYg record);

    @Select("select sum(buyNum) from yyg_user_yg t where t.ygProductId=#{ygProductId} and t.buyUserId=#{buyUserId}")
    Long totalBuyNums(@Param("ygProductId") Long ygProductId, @Param("buyUserId") Long buyUserId);
}