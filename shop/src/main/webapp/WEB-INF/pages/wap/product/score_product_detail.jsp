<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="/commons/commons_resource_head.jsp"%>
 <style type="text/css">
.price {
  float: left;
  width: 50%;
  height: 2rem;
  color: #f54850;
  line-height: 2rem;
  font-size:1.2rem;
}
</style>
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
 <header id="header2">
 <h1>趣购详情</h1>
 <div class="back">
  <a class="ap-icon" href="javascript:history.back();"></a>
 </div>
 <div class="menu">
  <a class="icon-home ap-icon" href="/"></a>
 </div>
 </header>
 <link rel="stylesheet" href="${wapBase}/style/mobile/css/goods.css">
  <div id="content" class="container detail integral-goods-detail ">
   <div class="slider" id="single-item" style="position: relative">
    <div class="bd">
     <c:forEach items="${product.photoList}" var="photo">
      <div>
       <img src="${photo.photoPath}" id="buy_img_${product.id }" />
      </div>
     </c:forEach>
    </div>
    <ul class="slick-dots">
     <c:forEach items="${product.photoList}" var="photo">
      <li><button type="button"></button></li>
     </c:forEach>
    </ul>
   </div>
   <p class="title">
<span style="color: red;">${product.name }</span>
   </p>
  <div class="info ">
    <div class="bottom">
	<p class="price">
     <span style="color:#898989;">价格：</span>￥${product.singlePrice}.00
    </p>

      <p style="float:left;"><span style="color:#898989;font-size:1.2rem;">数量：</span>
      <div class="number" style="margin-right: 0px;">
       <input class="num-input" type="text" id="qty_${product.id}" data-max="${product.totalNum}" value="1" /> <a class="num-btn btn-plus" id="qty_plus" href="javascript:void(0);">+</a>
       <a class="num-btn btn-minus" id="qty_minus" href="javascript:void(0);">-</a>
      </div>
        <div class="bottom button-box ui-clr">
      <%-- <span class="btn-db" style="width:100%"><a href="javascript:void(0)" onclick="addToBuy('${product.id}','buy')">立即购买</a></span>  --%>
      <span class="btn-db" style="width:100%"><a href="/member/buy/integral_buy?integral=10&payType=5">立即购买</a></span>
     </div>
      <script type="text/javascript">
							var need_num = '${product.totalNum}';
							function add() {
								var div = $(".num-input");
								var num = div.val();
								num = parseInt(num);
								num += 1;
								div.val(num);
								}
							function reduce() {
								var div = $(".num-input");
								var num = div.val();
								num = parseInt(num);
								num -= 1;
								if (num < 1)
									return false;
								div.val(num);
							}

						</script>
     </div>
<script type="text/javascript">
							var need_num = '${product.totalNum}';

							window.onload = function(e) {
								//鼠标按钮时刻，抬起时刻
								var firstTime, lastTime;
								//定义计时器(判断2s后)
								var time1, time2;
								//周期性计时器;
								var flag = false;

								document.getElementById("qty_plus").onmousedown = function(e) {
									firstTime = new Date().getTime();
									var time1 = setTimeout(function() {
										flag = true;
										clearTimeout(time1);
									}, 100);
									time2 = setInterval(function() {
										if (flag == true) {
											add();
										}
									}, 100);
								}
								document.getElementById("qty_minus").onmousedown = function(e) {
									firstTime = new Date().getTime();
									var time1 = setTimeout(function() {
										flag = true;
										clearTimeout(time1);
									}, 100);
									time2 = setInterval(function() {
										if (flag == true) {
											reduce();
										}
									}, 100);
								}
									document.onmouseup = function(e) {
									lastTime = new Date().getTime();
									var someTime = lastTime - firstTime;
									someTime = someTime / 1000;
						
									if (someTime < 2) {
										if (e.target.id == "qty_plus") {
											add();
											flag = false;
											clearInterval(time2);
										} else if (e.target.id == "qty_minus") {
											reduce();
											flag = false;
											clearInterval(time2);
										}
									} else {
										flag = false;
										clearTimeout(time2);
									}
								}


								$(".num-input").blur(function() {
									var max = $(this).attr('data-max') * 1;
									if ($(this).val() > max) {
										$(this).val(max);
									}
								});

							}
						</script>
     </div>


   </div>

 <div id="content" class="container detail">
  <div class="tab-item detail-info">
   <div style="text-align: center;">${oProduct.content}</div>
  </div>
 </div>
 <!--  公共底部 -->
  <c:set var="footType" value="product" />
  <%@ include file="/index/index_foot.jsp"%>
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
