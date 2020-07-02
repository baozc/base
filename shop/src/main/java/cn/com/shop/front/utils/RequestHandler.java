package cn.com.shop.front.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 '微信支付服务器签名支付请求请求类
 '============================================================================
 'api说明：
 'init(app_id, app_secret, partner_key, app_key);
 '初始化函数，默认给一些参数赋值，如cmdno,date等。
 'setKey(key_)'设置商户密钥
 'getLasterrCode(),获取最后错误号
 'GetToken();获取Token
 'getTokenReal();Token过期后实时获取Token
 'createMd5Sign(signParams);生成Md5签名
 'genPackage(packageParams);获取package包
 'createSHA1Sign(signParams);创建签名SHA1
 'sendPrepay(packageParams);提交预支付
 'getDebugInfo(),获取debug信息
 '============================================================================
 '*/
@SuppressWarnings("all")
public class RequestHandler {

	/** 商户参数 */
	private String appid;
	private String appkey;
	private String partnerkey;
	private String appsecret;
	private String key;

	private HttpServletRequest request;

	private HttpServletResponse response;
	/**
	 * 初始化函数。
	 */
	public void init( String partner_key) {
		this.key = partner_key;
	}

	public void init() {
	}
	// 设置密钥

	public void setKey(String key) {
		this.partnerkey = key;
	}
	// 设置微信密钥
	public void setAppKey(String key) {
		this.appkey = key;
	}
	/**
	 * 收银专用
	 */
	public String createSign1(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"sign".equals(k) && !"redirect_uri".equals(k)) {
				sb.append(k + "=" + v + "&");
				
			}else{
				sb.append(k + "=" + v );
			}
		}
		sb.append(this.getKey());
		System.out.println("sb----------->" + sb);
		String sign = MD5Utils.MD5Encode(sb.toString(), "utf-8");
		System.out.println("sign----------->" + sign);
		return sign;
	}
	public String createSign2(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		sb.append("{");
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"udid".equals(k) && !"redirect_uri".equals(k)) {
				sb.append( "'"+k + "':'"+ v + "',");
				
			}else{
				sb.append("'"+k + "':'"+v +"'");
			}
		}
		sb.append("}");
		sb.append(this.getKey());
		System.out.println("sb----------->" + sb);
		String sign = MD5Utils.MD5Encode(sb.toString(), "utf-8");
		System.out.println("sign----------->" + sign);
		return sign;
	}
	public String createSign2a(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		sb.append("{");
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"udid".equals(k) && !"redirect_uri".equals(k)) {
				sb.append( "'"+k + "':'"+ v + "',");
				
			}else{
				sb.append("'"+k + "':'"+v +"'");
			}
		}
		sb.append("}");
		return sb.toString();
	}
	public String createSign3(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"mchid".equals(k) && !"redirect_uri".equals(k)) {
				sb.append(k + "=" + v + "&");
				
			}else{
				sb.append(k + "=" + v );
			}
		}
		sb.append(this.getKey());
		System.out.println("sb----------->" + sb);
		String sign = MD5Utils.MD5Encode(sb.toString(), "utf-8");
		System.out.println("sign----------->" + sign);
		return sign;
	}
	public String createSign4(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"udid".equals(k) && !"redirect_uri".equals(k)) {
				sb.append(k + "=" + v + "&");
				
			}else{
				sb.append(k + "=" + v );
			}
		}
		sb.append(this.getKey());
		System.out.println("sb----------->" + sb);
		String sign = MD5Utils.MD5Encode(sb.toString(), "utf-8");
		System.out.println("sign----------->" + sign);
		return sign;
	}
	public String createSign4a(SortedMap<String, String> packageParams) {
		StringBuffer sb = new StringBuffer();
		Set es = packageParams.entrySet();
		Iterator it = es.iterator();
		while (it.hasNext()) {
			Map.Entry entry = (Map.Entry) it.next();
			String k = (String) entry.getKey();
			String v = (String) entry.getValue();
			if (null != v && !"".equals(v) && !"udid".equals(k) && !"redirect_uri".equals(k)) {
				sb.append(k + "=" + v + "&");
				
			}else{
				sb.append(k + "=" + v );
			}
		}
		return sb.toString();
	}
	public String createSign(String postJson) {
		postJson +=this.getKey();
		System.out.println("sb----------->" + postJson);
		String sign = MD5Utils.MD5Encode(postJson, "utf-8");
		System.out.println("sign----------->" + sign);
		return sign;
	}

	public String getKey() {
		return key;
	}

	public static void main(String[] args) {
		SortedMap<String, String> packageParams = new TreeMap<String, String>();
		packageParams.put("uid", "12");
		packageParams.put("price", "12");
		packageParams.put("orderid", "65656");
		packageParams.put("istype", "10001");
		packageParams.put("notify_url", "http://192.168.3.94/pay/index/Blog/Order/myorder.html");
		packageParams.put("return_url", "http://192.168.3.94/pay/index/Blog/Order/myorder.html");

		packageParams.put("format", "测试");

		packageParams.put("goodsname", "测试");

		packageParams.put("orderuid", "55665");

		packageParams.put("token", "355");
		// RequestHandler reqHandler = new RequestHandler(null, null);
		// String mySign = reqHandler.createSign1(packageParams);
	}
}
