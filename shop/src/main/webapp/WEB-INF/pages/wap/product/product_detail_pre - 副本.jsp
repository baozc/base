<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="../commons/commons_resource_head.jsp"%>
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
 <link rel="stylesheet" href="/assets/style/mobile/css/goods.css">
  <div id="content" class="container detail">
   <div class="slider" id="single-item" style="position: relative">
    <div class="bd">
     <c:forEach items="${oProduct.photoList}" var="photo">
      <div>
       <img src="${photo.photoPath}" id="buy_img_${product.id }" />
      </div>
     </c:forEach>
    </div>
    <ul class="slick-dots">
     <c:forEach items="${oProduct.photoList}" var="photo">
      <li><button type="button"></button></li>
     </c:forEach>
    </ul>
   </div>
   <div class="title">
   <p class="title">
    (第${product.period }期)${product.name }<span style="color: red;" title=""></span>
   </p>
   </div>
         <div class="joinAndGet" style="background-color:#f02d33">
            <div class="award_No">
                 <div class="awrd_sz">
                    <em class="pCountdown">即将揭晓时间： <b id="divLotteryTime"><b id="jx_load" style="display: none;">加载中...</b>
                    <b id="jx_clock" style=""><b id="liMinute">??</b>:<b id="liSecond">??</b>.<b id="liMilliSecond">??</b></b></b></em>
                 </div>
            <div class="computational_details"><a>等待中...</a></div>
           </div>
        </div>
		<script type="text/javascript">
            var lottery = 0;
            var Secondms_jx = 60*1000;
            var minutems_jx = 1000;
            var wait_time = 0;
        
            function show_date_time(diff,obj) {
				
                if(diff <= 0) {
                    $("#liMinute").html('00');
                    $("#liSecond").html('00');
                    $("#liMilliSecond").html('00');
                    if(lottery==0){ //#
                        rTimeout = window.clearTimeout(rTimeout);
                        $('#divLotteryTime').html("<span >计算中...</span>");
        
                        setTimeout(function(){
                            lottery = 1;
                            window.location.reload();
                        }, 5000);
                                    }
                    return false;
                }
        
                DifferSecond   = Math.floor(diff / Secondms_jx);
                diff -= DifferSecond * Secondms_jx;
                DifferMinute   = Math.floor(diff / minutems_jx);
                diff -= DifferMinute * minutems_jx;
        
                if(DifferSecond.toString().length < 2) DifferSecond = '0'+DifferSecond;
                if(DifferMinute.toString().length < 2) DifferMinute = '0'+DifferMinute;
        
                wait_time=wait_time-1000;
                $("#liMinute").html(DifferSecond);
                $("#liSecond").html(DifferMinute);
        
                if($("#jx_load").is(':visible')){
                    $("#jx_load").hide();
                    $('#jx_clock').show();
                }
            }
            $(document).ready(function(){
                wait_time = parseInt("${lose_time}");				
                rTimeout = window.setInterval(function(){ show_date_time(wait_time, null); }, 1000);
				show_date_time(wait_time, null);
        
                //毫秒单独计时
                var h = 100;
                timeID_h_jx = window.setInterval(function(){
                    if(h<=0) h = 100;
                    h = parseInt(h)-1;
                    if(h.toString().length < 1) h = '00';
                    if(h.toString().length == 1) h = '0'+h;
                    if(h.toString().length > 2) h = '99';
        
                    $("#liMilliSecond").html(h);
                }, 10);
            } );
        </script>
	
    <style type="text/css">
        .yunbuy_other .in_dianpu { margin-bottom: 10px; height: 90px;font-size: 13px;line-height: 23px; padding: 0 10px;  }
        .in_dianpu img{ float: right; padding: 10px 0; width: 45px; position: relative; top: 5px;}
        .in_dianpu .dianpuinfo{ float: left;height: 20px;padding: 13px 0 0 5px; }
        .you_fahuo{ font-weight: 300;font-size: 1.2rem;color:#333 }
        .in_dianpu .right_herf{ padding: 18px 0; font-size: 16px;}
    </style>
    </div>
   </div>
   <div class="detail-userCodes ">
    <c:choose>
     <c:when test="${empty user.id }">
      <p>
       看不到？是不是没登录或是没注册？ <a href="/login?back=/product/${product.id }" class="color02">登录</a> <a href="/regist?back=/product/${product.id }" class="color02">注册</a>
      </p>
     </c:when>
     <c:when test="${myTotalBuyNums==0}">
      <p class="detail-userCodes-blank">您还没有参与本次趣购哦！</p>
     </c:when>
     <c:when test="${myTotalBuyNums<10}">
      <p>
       您本期总共参与了<b class="color01">${myTotalBuyNums }</b>人次
      </p>
      <p class="codes">
       您的号码: <span class="m-detail-code"> <c:forEach items="${myBuyRecords}" var="myBuyRecord">
         <c:forEach items="${fn:split(myBuyRecord.buyNos, ',')}" var="buyNo">
          <b>${buyNo }</b>
         </c:forEach>
        </c:forEach>
       </span>
      </p>
     </c:when>
     <c:otherwise>
     </c:otherwise>
    </c:choose>
   </div>
   <ul class="yunbuy_other">
    <a href="/product/${product.id}/info"><b></b>商品图文详情<label>（建议WIFI下使用）</label></a>
    <a href="/product/${product.id}/win"><b></b>往期揭晓</a>
   </ul>
  <div class="record" id="buyRecord">
   <div class="t-clock">
    <span class="ap-icon icon-clock"></span>
   </div>
  </div>
  <div class="loading getMore_buyRecord"></div>
  <script src="${wapBase}/style/mobile/js/jquery-pageload.js"></script> 
   <script type="text/javascript">
		var type = 'buyRecord';
		$('#' + type).pageload({
			url : '/product/${product.id}/' + type,
			param : 'id=${product.id}',
			trigger : '.getMore_' + type
		});
	</script> 
  </div>
  <!--  公共底部 -->
  <c:set var="footType" value="product" />
<%@ include file="../../commons/taglibs.jsp"%>
<div class="new-foot1"></div>
<ul class="new-foot">
 <li><a href="/" <c:if test="${not empty footType and footType eq 'index' }">class="hover"</c:if>> <em><i class="iconfont icon-zhuye"></i></em>
   <p>首页</p>
 </a></li>
 <li><a href="/product" <c:if test="${not empty footType and footType eq 'product' }">class="hover"</c:if>> <em><i class="iconfont icon-yiyuangoujilu"></i></em>
   <p>分类</p>
 </a></li>
 <li><a href="/win" <c:if test="${not empty footType and footType eq 'win' }">class="hover"</c:if>> <em><i class="iconfont icon-sfsiconyidongduankaijiang"></i></em>
   <p>最新揭晓</p>
 </a></li>
 <li><a href="/member" <c:if test="${not empty footType and footType eq 'member' }">class="hover"</c:if>> <em><i class="iconfont icon-01huiyuanzhongxin"></i></em>
   <p>我的</p>
 </a></li>
<li class="duihuan_d liji">
  <a href="/product/${newYgProduct.id}.html"> 进入新一期 </a>
</li>
</ul>
<ul class="foot-fix">
 <li class="fix-top"><a id="top">TOP</a></li>
</ul>
<iframe name="iframeNews" style="display: none;"></iframe>
<span id="BIDNUMBER" style="display: none;"></span>
<script type="text/javascript">
	var logCount = '002654977';
</script>
<script src="${wapBase}/style/mobile/js/script.js"></script>
<div style="display: none"></div>
<script type="text/javascript">
	/*var tjtag = document.createElement('script');
	tjtag.src = 'admin/js/statistic.js';
	tjtag.type = 'text/javascript';
	document.body.appendChild(tjtag);*/
</script>
                <span class="btn-db btn-cart"></span>
<style type="text/css">
    .new-foot .duihuan_d{ height: 53px; }
    .new-foot .duihuan_d a{ font-weight: 700;font-size: 14px;padding: 10px 20px;color:#fff; background-color: #f02d33;margin: 0 10px; border-radius: 20px;}
    .new-foot .duihuan_d a:hover{ color:#fff; }
        .new-foot li{ width: 15% }
    .new-foot .liji{ width: 35%; float: right;  margin-top: 1em;}
    .new-foot .jiaru{ background:#fdb933; width: 28%  }
    
    .new-foot .qingdan a{ padding-right: 30px;  }
    .new-foot li a span{ right: 32px; }
	.yunbuy_other .in_dianpu { margin-bottom: 10px; height: 90px;font-size: 13px;line-height: 23px; padding: 0 10px;  }
     .in_dianpu img{ float: right; padding: 10px 0; width: 45px; position: relative; top: 5px;}
    .in_dianpu .dianpuinfo{ float: left;height: 20px;padding: 13px 0 0 5px; }
    .you_fahuo{ font-weight: 300;font-size: 1.2rem;color:#333 }
    .in_dianpu .right_herf{ padding: 18px 0; font-size: 16px;}
	.btn-last {
    width: 40px;
    right: -48px;
    font-size: 13px;
    line-height: 30px;
    background-color: #f02d33;
    color: #fff;
    border-radius: 5px;
}
</style>
<%@ include file="../commons/commons_resource_foot.jsp"%>
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
