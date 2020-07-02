package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;

import cn.com.easy.utils.SpringContextHolder;
import cn.com.shop.configuration.BaseConfig;
import lombok.Data;

@Data
public class YygYgProduct implements Serializable {
    /**初始购买号码*/
    public final static long INIT_BUY_NO = 10000000;
    /**最大总份数*/
    public final static long MAX_BUY_NUM = 99999999;

    private Long id;

    private String createby;

    private Long createbyid;

    private Date createtime;

    private Boolean deletestatus;

    private String lastmodifyby;

    private Long lastmodifybyid;

    private Date lastmodifytime;

    private Long version;

    private Long brandid;

    private String cateid;

    private Long storeid;

    private Long lastuserbuydatelong;

    public Date getLastUserBuyDate(){
        if(lastuserbuydatelong==null){
            return null;
        }
        return new Date(lastuserbuydatelong);
    }

    private Long totalnum;

    private Long usednum;

    private Long leavenum;

    private Long origprice;

    private Long singleprice;

    private Integer status;

    private Long limitperiods;

    private Boolean llscno;

    private Long llscperiodno;

    private String logopath;

    private String name;

    private String title;

    private Integer period;

    private Long preygproductid;

    private Long productid;

    private Date publishdate;

    private Boolean recommend;

    private Long seqno;

    private Date windate;

    private Long winno;

    private Long winuserbuydatelong;

    /**购买（夺宝）时间*/
    public Date getWinUserBuyDate(){
        if(winuserbuydatelong==null){
            return null;
        }
        return new Date(winuserbuydatelong);
    }

    private Long winuserbuynum;

    private Long winuserid;

    private String winuserlogopath;

    private String winusernickname;

    private Boolean zdwin;

    private String winuseripaddr;

    private String weixinBuy;

    private String leavebuynoscontentid;

    private static final long serialVersionUID = 1L;

    /**揭晓时间长*/
    public Long getPublishdateLong(){
        if(publishdate!=null){
            return publishdate.getTime()-System.currentTimeMillis();
        }
        return 0L;
    }

    public String getLogopath() {
        if (logopath != null && logopath.startsWith("http")) {
            return logopath;
        }
        BaseConfig baseConfig = SpringContextHolder.getBean(BaseConfig.class);
        return baseConfig.getImgServerUrl() + logopath;
    }
}