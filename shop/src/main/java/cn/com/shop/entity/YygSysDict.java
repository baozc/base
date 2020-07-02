package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class YygSysDict implements Serializable {
    /** */
    /** 根节点id */
    public static final long ROOT_ID = 0L;
    /** 商品分类 */
    public static final long ROOT_PRODUCT = 1L;
    /** 品牌 */
    public static final long ROOT_BRAND = 20L;
    /**广告位*/
    public static final long ROOT_ADV = 50L;
    /**广告位-首页幻灯片*/
    public static final long  ROOT_ADV_HOME_SLIDE = 51L;
    /**广告位-app首页幻灯片*/
    public static final long  ROOT_ADV_HOME_SLIDE_APP = 52L;

    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private Boolean display;

    private String icons;

    private String name;

    private Long parentid = ROOT_ID;

    private Long seqno;

    private String val;

    private static final long serialVersionUID = 1L;

}