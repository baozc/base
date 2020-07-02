<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="/commons/commons_resource_head.jsp"%>
 <title>${product.name }</title>
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
 <link rel="stylesheet" href="${wapBase}/style/mobile/css/goods.css">
  <div id="content" class="container detail">
   <div style="clear: both; height: 1px; width: 100%;"></div>

   <div class="detail-userCodes" style="padding: 10px">
    <div class="pClosed">本趣购已商品已下架</div>
   </div>
  </div>
  <!--  公共底部 -->
  <c:set var="footType" value="product" />
<%--   <%@ include file="../index/index_foot.jsp"%> --%>
  <%@ include file="/index/index_foot_new.jsp"%>
  <!--  公共底部 -->
</body>
</html>
<script src="${wapBase}/style/touchslide.1.1.js"></script>
<script src="${wapBase}/style/mobile/js/jquery-pageload.js"></script>
<script src="${wapBase}/style/mobile/js/jquery.more.js"></script>
<script type="text/javascript">
	$(function() {
		TouchSlide({
			slideCell : "#single-item",
			mainCell : ".bd",
			titCell : ".slick-dots li",
			titOnClassName : "slick-active"
		});
		tabs(".tab", ".tab-nav li", ".tab-item", "on", "click");

		$('.m-detail-codes-btn').bind('click', function() {
			$(this).hide();
			$('.m-detail-code').hide();
			$('.m-detail-codes').show();
			$('.m-detail-codes-btn-hide').show();
		})
		$('.m-detail-codes-btn-hide').bind('click', function() {
			$(this).hide();
			$('.m-detail-codes').hide();
			$('.m-detail-code').show();
			$('.m-detail-codes-btn').show();
		})
	});

	var isLoad = {
		"join" : false,
		"win" : false,
		"share" : false
	};

	function mLoad(type) {
		if (isLoad[type] == false) {
			if (type == 'share') {
				$('.shareList').more({
					'address' : '../../content/share_ajax/all@goods_id=34&type=db',
					'amount' : 10
				})
			} else {
				$('#' + type).pageload({
					url : '../ajax_' + type,
					param : 'id=874',
					trigger : '.getMore_' + type
				});
			}
			isLoad[type] = true;
		}
	}
</script>
