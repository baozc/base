package cn.com.shop.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import cn.com.easy.utils.FastJSONUtils;
import cn.com.shop.dto.ProductPhotoDto;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;

@Data
public class YygProduct implements Serializable {
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

    private Long storeid;

    private String cateid;

    private Long contentid;

    private String content;

    private Long limitperiods;

    private String logopath;

    private String name;

    private String title;

    private Long origprice;

    private Long totalnum;

    private Long singleprice;

    private Long period;

    private String photos;

    private Boolean recommend;

    private String seodesc;

    private String seokey;

    private String seotitle;

    private Long seqno;

    private Integer status;

    private String weixinBuy;

    private static final long serialVersionUID = 1L;

    public List<ProductPhotoDto> getPhotoList(){
        if(StringUtils.isNoneBlank(photos)){
            return FastJSONUtils.toArray(photos, ProductPhotoDto.class);
        }
        return Lists.newArrayList();
    }

}