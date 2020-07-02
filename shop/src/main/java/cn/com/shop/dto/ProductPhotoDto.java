package cn.com.shop.dto;

import cn.com.easy.utils.SpringContextHolder;
import cn.com.shop.configuration.BaseConfig;
import lombok.Data;

/**
 * 商品图片对象
 * @author lvzf	2016年8月23日
 *
 */
@Data
public class ProductPhotoDto {
	 private String photoPath;
	 private String remark;
	/**
	 * get photoPath  
	 * @return   
	 * @author lvzf 2016年8月23日
	 */
	public String getPhotoPath() {		
		if(photoPath!=null && photoPath.startsWith("http")){
			return photoPath;
		}
		BaseConfig baseConfig = SpringContextHolder.getBean(BaseConfig.class);
		return baseConfig.getImgServerUrl()+photoPath;
	}

}
