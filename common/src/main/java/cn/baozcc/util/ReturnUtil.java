package cn.baozcc.util;

import java.util.HashMap;
import java.util.Map;

import cn.baozcc.util.result.OaResult;

/**
 * 接口返回值工具类
 * 
 * @author liux
 *
 */
@SuppressWarnings("unused")
public class ReturnUtil {

	/**
	 * 请求成功
	 */
	public final static String ReturnSuccess = "SUCCESS";

	public final static String ReturnSuccessStr = "1";

	/**
	 * 请求失败
	 */
	public final static String ReturnFailed = "FAILED";

	public final static String ReturnFailedStr = "0";

	/**
	 * 获取返回结果
	 * 
	 * @param result 请求结果
	 * @param description 描述信息
	 * @return map
	 * @auth baozhichao
	 * @date 2018年3月9日 下午2:21:32
	 */
	public static Map<String, Object> getReturnInfo(String result, String description) {
        return getReturnDesc("result", result, "description", description);
    }

    /**
     * 返回请求数据方法
     * @param result 状态值
     * @param description 描述
     * @param jsonData 数据
     * @return
     */
    public static Map<String, Object> getReturnInfo(String result, String description, Object jsonData) {
        return getObjectMap(result, description, jsonData);
    }

	/**
	 * 获取返回结果
	 * @param description 描述信息
	 * @return map
	 * @auth baozhichao
	 * @date 2018年3月9日 下午2:21:32
	 */
	public static Map<String, Object> getReturnSuccess(String description) {
        return getReturnDesc("result", ReturnSuccess, "description", description);
    }

	/**
	 * 获取返回结果
	 * @param jsonData 返回数据
	 * @return map
	 * @auth baozhichao
	 * @date 2018年3月9日 下午2:21:32
	 */
	public static Map<String, Object> getReturnSuccess(Object jsonData) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", ReturnSuccess);
		map.put("description", "");
		map.put("jsonData", jsonData);
		return map;
	}

	/**
	 * 获取返回结果
	 * @param description 描述信息
	 * @return map
	 * @auth baozhichao
	 * @date 2018年3月9日 下午2:21:32
	 */
	public static Map<String, Object> getReturnFailed(String description) {
        return getReturnDesc("result", ReturnFailed, "description", description);
    }

	public static OaResult getCardSuccess(String description) {
        return new OaResult(ReturnSuccessStr, description);
	}
	
	public static OaResult getCardSuccess(String description, Object jsonData) {
        return new OaResult(ReturnSuccessStr, description, jsonData);
    }

	public static OaResult getCardFailed(String description) {
        return new OaResult(ReturnFailedStr, description);
	}

	public static OaResult getCardFailed(String description, Object jsonData) {
        return new OaResult(ReturnFailedStr, description, jsonData);
    }

    @SuppressWarnings("SameParameterValue")
    private static Map<String, Object> getReturnDesc(String key0, Object val0, String key1, Object val1) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put(key0, val0);
        map.put(key1, val1);
        return map;
    }

    private static Map<String, Object> getObjectMap(Object result, Object description, Object jsonData) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("result", result);
        map.put("description", description);
        map.put("jsonData", jsonData);
        return map;
    }
}
