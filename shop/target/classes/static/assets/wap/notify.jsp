<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.security.MessageDigest"%>
<%@page import="cn.com.yyg.pay.util.DuoFuTongAliPayH5Utils"%>
<%@page import="java.security.NoSuchAlgorithmException"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>回调通知</title>
<script src="/assets/style/jquery-1.8.3.min.js"></script>
<script src="/assets/style/common.js"></script>

</head>
<body>
<%!public static String md5(String str) throws NoSuchAlgorithmException {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            //字符数组转换成字符串
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            // 32位加密
            return buf.toString().toUpperCase();
            // 16位的加密
             //return buf.toString().substring(8, 24).toUpperCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
%>
    
<%
	System.out.println("**********进多富通入页面回调*******");
    String memberid=request.getParameter("memberid");
    String orderid=request.getParameter("orderid");
    String amount=request.getParameter("amount");
    String datetime=request.getParameter("datetime");
    String returncode=request.getParameter("returncode");
    String transaction_id = request.getParameter("transaction_id");
    String attach=request.getParameter("attach");
    String sign=request.getParameter("sign");
    String keyValue="7vxg0a76ki6fu5x3ipxpxn8jvc3tm17y";
    String SignTemp="amount="+amount+"&datetime="+datetime+"&memberid="+memberid+"&orderid="+orderid+"&returncode="+returncode+"&transaction_id="+transaction_id+"&key="+keyValue+"";
    String md5sign=md5(SignTemp);//MD5加密
    System.out.println(SignTemp);
    System.out.println(sign+"---两边加密判断---"+(md5sign));
    
    if (sign.equals(md5sign)){
        if(returncode.equals("00")){
            //支付成功，写返回数据逻辑
            PrintWriter pw=response.getWriter();
            pw.write("OK");
            
			URL PAY_URL = new URL("http://iarvb.cn/ialipay/duoFuTong_notify");
			Map<String, String> params = new HashMap<String, String>();
			params.put("orderid", orderid);
			DuoFuTongAliPayH5Utils.sendPostMessage(PAY_URL, params);
           
        }else{
            PrintWriter pw=response.getWriter();
            pw.write("支付失败");
        }
    }else{
        PrintWriter pw=response.getWriter();
        pw.write("验签失败");
    }
%>
	
</body>
</html>