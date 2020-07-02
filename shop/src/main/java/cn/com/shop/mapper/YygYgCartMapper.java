package cn.com.shop.mapper;

import java.util.List;

import cn.com.shop.entity.YygYgCart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

public interface YygYgCartMapper {
    int deleteByPrimaryKey(Long id);

    int insert(YygYgCart record);

    int insertSelective(YygYgCart record);

    YygYgCart selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(YygYgCart record);

    int updateByPrimaryKey(YygYgCart record);

    @Delete({"<script>",
            "delete from yyg_yg_cart a where a.userId=#{userId} and a.ygProductId in ",
            "<foreach collection='ygProductIds' item='productId' open='(' separator=',' close=')'>",
            "#{productId}",
            "</foreach>",
            "</script>"})
    int deleteByUserIdAndYgProductIds(@Param("userId") Long userId, @Param("ygProductIds") List<Long> ygProductIds);

    @Delete("delete from yyg_yg_cart a where a.userId=#{userId} ")
    int deleteByUserId(@Param("userId") Long userId);
}