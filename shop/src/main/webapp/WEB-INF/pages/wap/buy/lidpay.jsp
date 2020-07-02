<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
<%@ include file="../commons/commons_resource_head.jsp"%>
<title>下单支付</title>
<meta charset="utf-8"/>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=2,user-scalable=no"/>
<link rel="stylesheet" href="${wapBase}/style/mobile/css/common.css"/>
<link rel="stylesheet" href="${wapBase}/style/mobile/css/font/iconfont.css"/>
<script src="${wapBase}/style/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="${wapBase}/style/layer/layer.min.js"></script>
<script type="text/javascript" src="${wapBase}/style/common.js"></script>
<style>
	*{margin:0; padding:0;}
	a{text-decoration: none;}
	img{max-width: 100%; height: auto;}
	.weixin-tip{display: none; position: fixed; left:0; top:0; bottom:0; background: rgba(0,0,0,0.8); filter:alpha(opacity=80);  height: 100%; width: 100%; z-index: 100;}
	.weixin-tip p{text-align: center; margin-top: 10%; padding:0 5%;}
</style>
</head>
<body>
	<div class="weixin-tip">
		<p>
			<img src="${wapBase}/style/images/live_weixin.png" alt="浏览器打开"/>
		</p>
	</div>
	<script type="text/javascript">
        $(window).on("load",function(){
	        var winHeight = $(window).height();
			function is_weixin() {
			    var ua = navigator.userAgent.toLowerCase();
			    if (ua.match(/MicroMessenger/i) == "micromessenger") {
			        return true;
			    } else {
			        return false;
			    }
			}
			var isWeixin = is_weixin();
			if(isWeixin){
				$(".weixin-tip").css("height",winHeight);
	            $(".weixin-tip").show();
			}
        })

	</script>
	
</body>
</html>