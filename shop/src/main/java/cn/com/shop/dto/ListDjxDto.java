package cn.com.shop.dto;

import java.util.List;

public class ListDjxDto {
	
	/** 内容 **/
	private String ids;
	private List<ListDto> list;



	public  ListDjxDto(String ids, List<ListDto> list) {
		this.ids = ids;
		this.list = list;
	}

	/**
	 * get content
	 * 
	 * @return
	 * @author linwk 2016年9月20日
	 */
	public String getIds() {
		return ids;
	}

	/**
	 * set content
	 * 
	 * @param content
	 * @author linwk 2016年9月20日
	 */
	public void setIds(String ids) {
		this.ids = ids;
	}
	
	/**
	 * get content
	 * 
	 * @return
	 * @author linwk 2016年9月20日
	 */
	public List<ListDto> getList() {
		return list;
	}

	/**
	 * set content
	 * 
	 * @param content
	 * @author linwk 2016年9月20日
	 */
	public void setList(List<ListDto> list) {
		this.list = list;
	}


}