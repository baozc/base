<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="../commons/commons_resource_head.jsp"%>
 <title>${htmlTitleText }</title>
 <meta charset="utf-8">
  <meta name="keywords" content="${seoKeywords }" />
  <meta name="description" content="${seoDescription }" />
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=2,user-scalable=no">
   <link rel="stylesheet" href="${wapBase}/style/mobile/css/common.css">
    <link rel="stylesheet" href="${wapBase}/style/mobile/css/font/iconfont.css">
     <script src="${wapBase}/style/jquery-1.8.3.min.js"></script>
     <script type="text/javascript" src="${wapBase}/style/layer/layer.min.js"></script>
     <script type="text/javascript" src="${wapBase}/style/common.js"></script>
</head>
<body>
 <link rel="stylesheet" href="${wapBase}/style/mobile/css_02/font/iconfont.css">
  <link rel="stylesheet" href="${wapBase}/style/mobile/css/bootstrap.css">
   <link rel="stylesheet" href="${wapBase}/style/mobile/css/new_index.css">
    <link rel="stylesheet" href="${wapBase}/style/mobile/css_02/index.css">
 <script src="${wapBase}/js/lefttime.js"></script>
 <script src="${wapBase}/js/lefttime_jx.js"></script>
 <style type="text/css">
* {
	box-sizing: border-box;
}
.price {
  float: left;
  width: 60%;
  height: 2rem;
  line-height: 2rem;
  color: #f54850;
  font-size: 2.1rem;
}
.btn02 {
  display: block;
  width: 100%;
  height: 2.5rem;
  line-height: 2.5rem;
  text-align: center;
  color: #ffffff;
  font-size: 2.1rem;
  background-color: #f54859;
  border: 1px solid #f54850;
  border-radius: 5px;
}
.btn-buy {
  float: right;
  width: 170%;
  font-size: 1.5rem;
}
/*自营积分商品列表*/
.integral-goods-list {
  width: 100%;
  border: 1px solid #ccc;
  overflow: hidden;
}
.integral-goods-list ul {
  margin-right: -1px;
}
.integral-goods-list li {
  float: right;
  width: 50%;
  padding: 0.5rem;
  border-bottom: 1px solid #ccc;
  border-right: 1px solid #ccc;
}
.integral-goods-list li .pic {
  position: relative;
  display: block;
  width: 100%;
}
.integral-goods-list li .pic img {
  display: block;
  width: 100%;
  padding: 6px;
}
.integral-goods-list li .pic .mask {
  position: absolute;
  left: 0;
  bottom: 0;
  display: block;
  width: 100%;
  height: 1.6rem;
  background: #000;
  opacity: 0.5;
}
.integral-goods-list li .pic .text {
  position: absolute;
  left: 0;
  bottom: 0;
  display: block;
  width: 100%;
  height: 1.6rem;
  line-height: 1.6rem;
  text-align: center;
  color: #fff;
  font-size: 0.9rem;
}
.integral-goods-list li h3 {
  height: 2rem;
  line-height: 1.6rem;
  font-size: 0.95rem;
  overflow: hidden;
}
.integral-goods-list li h3 a {
  color: #333;
  font-size: 1.5rem;
}
.integral-goods-list li .attr {
  overflow: hidden;
}
.integral-goods-list li .attr .price {
  float: left;
  width: 60%;
  height: 2rem;
  line-height: 2rem;
  color: #f54850;
  font-size: 1.rem;
}
.integral-goods-list li .attr .btn-buy {
  float: right;
  width: 40%;
  font-size: 1.rem;
}
.new-index2 .new-box{padding:20px;font-size: 14px;}
.new-index2 .new-box em,.new-index2 .new-box em a{height: 100%;width: 100%;}
.new-index2 .new-box em img{max-width: 100%;max-height: 198px;}
.new-index2 .new-box h5{ font-size: 14px;}
</style>
 <header id="header" style="display: none;"> <a href="/" class="logo"><img src="${wapBase}/upload/images/gallery/3/0/109_src.png" /></a>
 <div class="u-nav">
  <a class="ap-icon" href="/"><img src="${wapBase}/style/mobile/images/search2.png" /></a>
 </div>
 </header>
 <div class="new_banner" id="new_banner">
  <div class="slider">
   <c:forEach items="${slides}" var="slide">
    <div>
     <a href="${slide.linkUrl}"><img src="${slide.photoPath}" /></a>
    </div>
   </c:forEach>
  </div>
  <ul class="slick-dots">
   <c:forEach items="${slides}" var="slide">
    <li><button type="button"></button></li>
   </c:forEach>
  </ul>
 </div>
            <style>
                .menu {
                    height: 120px;
					text-align: center;
                    border-bottom: 1px solid #eef2f6;
                }
            </style>
            <div class="menu">
                <div class="slider">
                                         <div>
                        <a href="/show.php">
                            <em>
                                <img src="/assets/images/308_src.png" />
                            </em>
                            <p>入住必读</p>
                        </a>
                    </div>
                                          <div>
                        <a href="/member/store.php">
                            <em>
                                <img src="/assets/images/309_src.png" />
                            </em>
                            <p>商家入驻</p>
                        </a>
                    </div>
                                          <div>
                        <a href="/charge.php">
                            <em>
                                <img src="/assets/images/310_src.png" />
                            </em>
                            <p>微信投诉</p>
                        </a>
                    </div>
                                          <div>
                        <a href="/member">
                            <em>
                                <img src="/assets/images/311_src.png" />
                            </em>
                            <p>会员中心</p>
                        </a>
                    </div>
                                               </div>
            </div>
 <div class="new-inex1 demo" id="buy_nav" style="margin-top:0px;">
    <div id="container" class="clearfix new-index2 list">
  <div class="integral-goods-list" style="position: relative">
     <ul id="load-more" data-param="action=selfgoods">
	 <c:forEach items="${scoreproduct}" var="item">
      <c:if test="${item.deleteStatus eq false }">

	 <li> 
	 <a class="pic" href="/product/score/${item.id }.html">
		<img src="${item.logoPath }" alt="${item.name }" width="100%">
		<span class="mask"></span><span class="text">购买赠送${item.origPrice }积分</span>
		</a>
     <h3>
      <a href="/product/score/${item.id }.html" title="${item.name }">
       ${item.name }</a>
     </h3>
     <div class="attr">
		<div class="price">￥${item.singlePrice }.00</div>
		<a href="/product/score/${item.id }.html" class="btn-buy btn02">立即购买</a>
	</div>
	 </li>

	</c:if>
   </c:forEach>
      </ul>
	  </div> 
  </div>
 </div>
 <script type="text/javascript">
		// 						var order = "ratio";
		// 						var sort = "desc";
		// 						var ExtendOptions = {
		// 							itemSelector : 'div.new-box',
		// 							path : function(index) {
		// 								return "yunbuy/index/" + index + "@order=" + order + "&sort=" + sort + "&load&skin=2&size=4";
		// 							}
		// 						};
	</script>
 <div class="loading getMore">
  <a class="next" href="#"></a>
 </div>
 <div class="load"></div>
 <script src="${wapBase}/style/scroll/debug.js"></script>
 <script src="${wapBase}/style/scroll/jquery.infinitescroll.js"></script>

 <!--  公共底部 -->
 <c:set var="footType" value="index" />
 <%@ include file="../index/index_foot.jsp"%>
 <!--  公共底部 -->
</body>
</html>
<script src="${wapBase}/style/touchslide.1.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//compaceIds();
		//setInterval('compaceIds()', 5 * 1000);
	});
	function compaceIds() {
		$.post('content/ajaxIds', 'skin=index_mobile&ids=' + $('#ids').val(), function(data) {
			if (data.error == 1) {
				$('#ids').val(data.ids);
				$('#win-list').prepend(data.html);
			}
		}, 'json');
	}
</script>
<script>
	TouchSlide({
		slideCell : "#new_banner",
		mainCell : ".slider",
		titCell : ".slick-dots li",
		titOnClassName : "slick-active",
		autoPlay : true,
		interTime : 5000
	});
	$(".new-index-1 li:odd").addClass("new-odd")
</script>
<script type="text/javascript" src="${mimeBase}/scripts/wap/index/newJiexiao.js"></script>
<script type="text/javascript" src="${wapBase}/style/mobile/js/slick.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(".new-index2 .new-box:odd").addClass("new-nr")
		$('.menu .slider').slick({
			autoplay : true,
			dots : true,
			arrows : false,
			slidesToShow : 5,
			slidesToScroll : 5,
			responsive : [ {
				breakpoint : 480,
				settings : {
					autoplay : true,
					arrows : false,
					dots : true,
					slidesToShow : 4,
					slidesToScroll : 4
				}
			} ]
		});
	});
</script>
<script type="text/javascript">
	
 <c:if test="${not empty errorNoMobile }">
 showTelError('${errorNoMobile}');
 </c:if>
 function showTelError(err) {
  alert(err);
  if (errorTelTimeOut) {
   clearTimeout(errorTelTimeOut);
  }
  var errorTelTimeOut = setTimeout(function() {
   window.location.replace("/member/info");
  }, 1.5 * 1000);
 }
 
 
</script>