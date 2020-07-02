package cn.com.shop.dto;

import java.util.List;

import cn.com.shop.entity.YygSysDict;
import cn.com.shop.entity.YygYgProduct;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 首页楼层
 *
 * @author lvzf    2016年8月22日
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class IndexFloorDto extends YygSysDict {
    /** */
    private static final long serialVersionUID = 152950547815602133L;
    /**
     * 楼层商品数据
     */
    private List<YygYgProduct> products;


}
