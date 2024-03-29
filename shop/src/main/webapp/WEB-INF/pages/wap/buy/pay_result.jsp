<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="../commons/commons_resource_head.jsp"%>
 <title>支付成功_${comName}</title>
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
<body>
 <header id="header2">
 <h1></h1>
 <div class="back">
  <a class="ap-icon" href="javascript:history.back();"></a>
 </div>
 <div class="menu">
  <a class="icon-home ap-icon" href="/"></a>
 </div>
 </header>
 <style type="text/css">
.pay_success {
	padding: 30px;
	font-size: 12px;
}

.pay_success h2 {
	font-size: 16px;
}

.pay_success .p1 {
	font-weight: bold;
	font-size: 12px;
}

.pay_success .p2 {
	font-size: 12px;
}

.share_box {
	margin: 10px 0 0;
	padding: 10px;
	background: #ececec;
	border-radius: 5px;
}
</style>
 <div id="content" class="container main">
  <div class="pay_success">
   <h2 class="color01">恭喜您，支付成功！</h2>
   <p class="p1">请等待系统为您揭晓！</p>
   <p class="p2">
    您现在可以 <a href="/win" class="color02">查看最新揭晓</a> 或 <a href="/product" class="color02">继续趣购</a>
   </p>
  </div>
 </div>
</body>
</html>
