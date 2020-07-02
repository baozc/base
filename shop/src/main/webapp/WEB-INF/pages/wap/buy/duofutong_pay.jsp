<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="../commons/commons_resource_head.jsp"%>
 <title>成富通支付_${comName}</title>
 <meta charset="utf-8">
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=2,user-scalable=no">
   <link rel="stylesheet" href="${wapBase}/style/mobile/css/common.css">
    <link rel="stylesheet" href="${wapBase}/style/mobile/css/font/iconfont.css">
     <script src="${wapBase}/style/jquery-1.8.3.min.js"></script>
     <script type="text/javascript" src="${wapBase}/style/layer/layer.min.js"></script>
     <script type="text/javascript" src="${wapBase}/style/common.js"></script>
</head>

<body onLoad="document.uncome.submit()">
<div id="Content">
  <div class="tabPages">我们正在为您连接银行，请稍等......</div>
</div>
<form name="uncome" action="${pay_url }" method="post">
	<input type="hidden" name="pay_memberid"  value="${pay_memberid}">
	<input type="hidden" name="pay_orderid"  value="${pay_orderid}">
	<input type="hidden" name="pay_applydate"  value="${pay_applydate}">
	<input type="hidden" name="pay_bankcode"  value="${pay_bankcode }">
	<input type="hidden" name="pay_notifyurl"  value="${pay_notifyurl }">
	<input type="hidden" name="pay_callbackurl"  value="${pay_notifyurl }">
	<input type="hidden" name="pay_amount"  value="${pay_amount }">
	<input type="hidden" name="pay_productname"  value="${pay_productname }">
	<input type="hidden" name="pay_productnum"  value="${pay_productnum }">
	<input type="hidden" name="pay_productdesc"  value="${pay_productdesc }">
	<input type="hidden" name="pay_producturl"  value="${pay_producturl }">
	<input type="hidden" name="pay_md5sign"  value="${pay_md5sign}">
</form>
</body>



</html>
