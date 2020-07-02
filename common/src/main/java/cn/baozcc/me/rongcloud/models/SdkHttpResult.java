package cn.baozcc.me.rongcloud.models;

import cn.baozcc.util.json.JsonUtil;

//对server sdk返回的封装
public class SdkHttpResult {

	private int code;
	private String result;

	public SdkHttpResult(int code, String result) {
		this.code = code;
		this.result = result;
	}

	public int getHttpCode() {
		return code;
	}

	public String getResult() {
		return result;
	}

	@Override
	public String toString() {
        return JsonUtil.format(this);
	}
}
