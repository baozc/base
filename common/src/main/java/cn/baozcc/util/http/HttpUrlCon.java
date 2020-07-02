package cn.baozcc.util.http;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.baozcc.me.rongcloud.util.CodeUtil;
import cn.baozcc.me.configuration.constant.RongCloud;
import cn.baozcc.me.rongcloud.models.SdkHttpResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"Duplicates", "unused"})
public class HttpUrlCon {
	
	private static Logger logger = LoggerFactory.getLogger(HttpUrlCon.class);

	public static final String POST = "POST";
	public static final String GET = "GET";

    private static final String APPKEY = "RC-App-Key";
    private static final String NONCE = "RC-Nonce";
    private static final String TIMESTAMP = "RC-Timestamp";
    private static final String SIGNATURE = "RC-Signature";
	
	private HttpURLConnection uc;
	
	private HttpUrlCon(HttpURLConnection uc){
		this.uc = uc;
	}
	
	/**
	 * 获取返回结果<strong>String</strong>
	 * @return 请求结果
	 * @throws Exception 
	 * @auth baozhichao
	 * @date 2018年1月5日 下午4:02:58
	 */
	public String getResult() throws Exception{
        StringBuilder sb = new StringBuilder();
        String s;
        BufferedReader reader = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        while((s = reader.readLine()) != null){
            sb.append(s);
        }
        logger.debug("result to string : {}", sb);
        return sb.toString();
    }

    /**
	 * 获取融云请求结果
	 * @return SdkHttpResult（code,result）
	 * @throws Exception
	 * @auth baozhichao
	 * @date 2018年1月5日 下午5:12:21
	 */
	public SdkHttpResult getSdkResult()
			throws Exception{
		String result;
		InputStream input;
		if (uc.getResponseCode() == 200) {
			input = uc.getInputStream();
		} else {
			input = uc.getErrorStream();
		}
		result = new String(readInputStream(input));
		return new SdkHttpResult(uc.getResponseCode(), result);
	}
	
	private byte[] readInputStream(InputStream inStream) throws Exception {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		byte[] bytes = new byte[1024];
		int len;
		while((len = inStream.read(bytes))!=-1){
			out.write(bytes, 0, len);
		}
		bytes = out.toByteArray();
		logger.debug("result to byte[] : ", bytes);
		
		inStream.close();
		out.close();
		
		return bytes;
	}
	
	@SuppressWarnings("unused")
    public static class Builder {
		private HttpURLConnection uc;
		private Map<String, String> map = new HashMap<>();
		private Map<String, Integer> mi = new HashMap<>();
		private Map<String, List<String>> ms = new HashMap<>();
		private Map<String, String[]> ma = new HashMap<>();
		/**
		 * 初始化连接对象，默认post连接<br>
		 * Content-Type 默认值<br>
		 * Charset UTF-8
		 * @param url
		 * @throws Exception
		 */
		public Builder(String url) throws Exception{
			URL uri = new URL(url);
			uc = (HttpURLConnection)uri.openConnection();
			uc.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8"); 
			uc.setRequestProperty("Charset", "UTF-8"); 
			uc.setDoOutput(true);
			uc.setInstanceFollowRedirects(true);
			uc.setRequestMethod("POST");
			uc.setConnectTimeout(1000 * 5);
			uc.setReadTimeout(1000 * 5);
		}
		/**
		 * 设置融云相关header信息
		 * @auth baozhichao
		 * @date 2018年4月3日 下午3:06:14
		 */
		public Builder rongCloudHeader(){
			String nonce = String.valueOf(Math.random() * 1000000);
			String timestamp = String.valueOf(System.currentTimeMillis() / 1000);
            String sign = CodeUtil.hexSHA1(RongCloud.appSecret + nonce + timestamp);

			header(APPKEY, RongCloud.appKey)
				.header(NONCE, nonce)
				.header(TIMESTAMP, timestamp)
				.header(SIGNATURE, sign);

            logger.info("App-Key: {}, secret:{}, Nonce:{}, Timestamp:{}, Signature:{}",
                    RongCloud.appKey, RongCloud.appSecret, nonce, timestamp, sign);
			return this;
		}

		
		/**
		 * 设置请求方式
		 * @param action POST/GET
		 * @auth baozhichao
		 * @date 2018年4月2日 下午1:51:41
		 */
		public Builder action(String action) throws Exception{
			uc.setRequestMethod(action);
			return this;
		}
		/**
		 * 设置请求头信息
		 * @param name 
		 * @param value
		 * @auth baozhichao
		 * @date 2018年4月2日 下午1:52:06
		 */
		public Builder header(String name, String value){
			uc.setRequestProperty(name, value);
			return this;
		}
		
		public Builder headerAuthorization(String account, String pwd){
			uc.setRequestProperty("Authorization", "Basic "
                    + Base64.getEncoder().encodeToString((account + ":" + pwd).getBytes()));
			return this;
		}

		public Builder param(String name, String value){
			map.put(name, value);
			return this;
		}

		public Builder param(Map<String, String> map){
		    this.map.putAll(map);
			return this;
		}

		public Builder param(String name, Integer value){
			mi.put(name, value);
			return this;
		}
		
		public Builder param(String name, String... value){
			ma.put(name, value);
			return this;
		}
		public Builder param(String name, List<String> value){
			ms.put(name, value);
			return this;
		}
		
		private String getParam(){
			if(map.isEmpty() && ms.isEmpty() && ma.isEmpty()){
				return null;
			}
			
			StringBuilder sb = new StringBuilder();
			for(Map.Entry<String, String> m : map.entrySet()){
				sb.append(m.getKey()).append("=").append(m.getValue()).append("&");
			}
			
			for(Map.Entry<String, List<String>> m : ms.entrySet()){
				for(String str: m.getValue()){
					sb.append(m.getKey()).append("=").append(str).append("&");
				}
			}
			
			for(Map.Entry<String, String[]> m : ma.entrySet()){
				for(String str: m.getValue()){
					sb.append(m.getKey()).append("=").append(str).append("&");
				}
			}
			
			for(Map.Entry<String, Integer> m : mi.entrySet()){
				sb.append(m.getKey()).append("=").append(m.getValue()).append("&");
			}
			sb.deleteCharAt(sb.length()-1);
			
			return sb.toString();
		}
		private String getParamEncode() throws Exception{
			if(map.isEmpty() && ms.isEmpty() && ma.isEmpty()){
				return null;
			}
			
			StringBuilder sb = new StringBuilder();
			for(Map.Entry<String, String> m : map.entrySet()){
				sb.append(m.getKey()).append("=").append(URLEncoder.encode(m.getValue(), "UTF-8")).append("&");
			}
			
			for(Map.Entry<String, List<String>> m : ms.entrySet()){
				for(String str: m.getValue()){
					sb.append(m.getKey()).append("=").append(URLEncoder.encode(str, "UTF-8")).append("&");
				}
			}
			
			for(Map.Entry<String, String[]> m : ma.entrySet()){
				for(String str: m.getValue()){
					sb.append(m.getKey()).append("=").append(URLEncoder.encode(str, "UTF-8")).append("&");
				}
			}
			
			for(Map.Entry<String, Integer> m : mi.entrySet()){
				sb.append(m.getKey()).append("=").append(m.getValue()).append("&");
			}
			sb.deleteCharAt(sb.length()-1);
			
			return sb.toString();
		}
		/**
		 * 发送请求数据
		 * @param str
		 * @throws IOException
		 * @auth baozhichao
		 * @date 2018年4月2日 下午1:52:50
		 */
		private void setBodyParameter(String str) throws IOException{
			DataOutputStream data = new DataOutputStream(this.uc.getOutputStream());
			logger.debug("request data : {}", str);
			data.write(str.getBytes());
			data.flush();
			data.close();
		}
		
		public HttpUrlCon connection(String str) throws Exception {
			DataOutputStream data = new DataOutputStream(this.uc.getOutputStream());
			logger.debug("request data : {}", str);
			data.write(str.getBytes());
			data.flush();
			data.close();
			
			return new HttpUrlCon(this.uc);
		}
		/**
		 * 发送请求
		 * @throws Exception
		 * @auth baozhichao
		 * @date 2018年4月2日 下午1:53:06
		 */
		public HttpUrlCon connection() throws Exception{
			String param = getParam();
            return sendRequest(param);
        }

		public HttpUrlCon connectionEncode() throws Exception{
			String param = getParamEncode();
            return sendRequest(param);
        }

        private HttpUrlCon sendRequest(String param) throws IOException {
            logger.debug("{}", param);
            if (param != null) {
                setBodyParameter(param);
            } else {
                uc.getResponseCode();
            }

            return new HttpUrlCon(this.uc);
        }

    }

	public String getHeader(String header) {
		
		return uc.getHeaderField(header);
	}
}
