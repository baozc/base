package cn.com.shop.dto;

public class ListDataDto {
	
	/** 内容 **/
	private String unit_kaijiang;
	private String is_ssc;
	private String hide_city;
	private String unit_yun;



	public  ListDataDto(String unit_kaijiang, String is_ssc) {
		this.unit_kaijiang = unit_kaijiang;
		this.is_ssc = is_ssc;
	}

	/**
	 * get content
	 * 
	 * @return
	 * @author linwk 2016年9月20日
	 */
	public String getUnit_kaijiang() {
		return unit_kaijiang;
	}

	/**
	 * set content
	 * 
	 * @param content
	 * @author linwk 2016年9月20日
	 */
	public void setUnit_kaijiang(String unit_kaijiang) {
		this.unit_kaijiang = unit_kaijiang;
	}
	
	/**
	 * get content
	 * 
	 * @return
	 * @author linwk 2016年9月20日
	 */
	public String getIs_ssc() {
		return is_ssc;
	}

	/**
	 * set content
	 * 
	 * @param content
	 * @author linwk 2016年9月20日
	 */
	public void setIs_ssc(String is_ssc) {
		this.is_ssc = is_ssc;
	}

	/**
	 * get content
	 * 
	 * @return
	 * @author linwk 2016年9月20日
	 */
	public String getHide_city() {
		return hide_city;
	}

	/**
	 * set content
	 * 
	 * @param content
	 * @author linwk 2016年9月20日
	 */
	public void setHide_city(String hide_city) {
		this.hide_city = hide_city;
	}
	/**
	 * get content
	 * 
	 * @return
	 * @author linwk 2016年9月20日
	 */
	public String getUnit_yun() {
		return unit_yun;
	}

	/**
	 * set content
	 * 
	 * @param content
	 * @author linwk 2016年9月20日
	 */
	public void setUnit_yun(String unit_yun) {
		this.unit_yun = unit_yun;
	}
}