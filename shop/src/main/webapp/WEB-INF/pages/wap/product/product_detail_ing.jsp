<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge"/>
 <%@ include file="/commons/commons_resource_head.jsp"%>
 <title>${product.name }</title>
 <meta charset="utf-8">
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=2,user-scalable=no">
   <link rel="stylesheet" href="${wapBase}/style/mobile/css/common.css">
    <link rel="stylesheet" href="${wapBase}/style/mobile/css/font/iconfont.css">
	<link rel="stylesheet" href="${wapBase}/style/layer/skin/default/layer.css">
     <script src="${wapBase}/style/jquery-1.8.3.min.js"></script>
     <script type="text/javascript" src="${wapBase}/style/layer/layer.js"></script>
     <script type="text/javascript" src="${wapBase}/style/common.js"></script>
<script type="text/javascript">
        //var href = "http://iarvb.cn/product/${product.id}/new.php";
        var href = "${url}";//"http://iarvb.cn/product/${product.id}";
        var title = "${product.name }";
        var pic = "${oProduct.photoList[0].photoPath}";
 </script> 

</head>
<body>
 <style>
    .detail{ margin-top: 0px;  }.detail .info_2 .title { background: none;padding-left: 0px; }
    .dianpuming {   overflow: hidden;
        text-overflow: ellipsis;
        white-space: nowrap;
        font-size: 1.6rem;
    }
    .bd{ max-height: 420px;line-height: 420px; }
    .detail .title{ padding: 10px 10px;margin-bottom: 10px;}
    .detail .info{
        color: #333
    }
    .detail .info .price span.qishu{
    display: inline-block;
    border: 1px solid #f02d33;
    border-radius: 5px;
    padding: 0 3px;
    }
    .detail .progressBar .wrap-bar{
        height: 8px;
    }
    .detail .progressBar .join01{
    background-color: #f0f8ff;
    padding: 10px;
    border-radius: 5px;
    font-weight: 600;
    }
    .detail .progressBar .join02{
    background-color: #fff0f5;
    padding: 10px;
    border-radius: 5px;
    font-weight: 600;
    }
    ul.yunbuy_other a img.icon{
    width: 20px;
    display: inline-block;
    vertical-align: text-bottom;
    margin-right: 5px;
    }
    .ad{
        background-color: #fff; 
        margin-bottom: 10px;
        padding: 10px;
    }
    .ad div{
        display: inline-block;
        width: 100px;
        height: 100px;
        margin-right: 10px;
        float: left;
    }
    .ad div img{
        width: 100%;
    }
    .ad dl{
        display: inline-block;
        float: left;
        line-height: 25px;
    }
    .ad dl dd{
        /* font-weight: 600; */
        font-size: 14px;
    } 
    .ad dl dt{
        font-size: 12px;
    } 
.box2{
    color: #666;
    line-height: 24px;
    margin: 0 8px 10px;
    padding: 0px 13px;
    border: 1px solid #DCDCDC;
    border-radius: 5px;
    background: #FFF none repeat scroll 0% 0%;
    box-shadow: 1px 1px 1px #E7E7E7;
	overflow: hidden;
}
.box2 p{
    display: block;
	height: 50px;
}
.box2s{
    color: #666;
    line-height: 24px;
    margin: 0 8px 10px;
    padding: 0px 13px;
    border: 1px solid #DCDCDC;
    border-radius: 5px;
    background: #FFF none repeat scroll 0% 0%;
    box-shadow: 1px 1px 1px #E7E7E7;
}
.box2s p{
    display: block;	
}
.box{
  margin-bottom: 10px;
  width:100%;
  height:auto;
  background-color:#fff;
}	
.integral{
	padding: 2px 4px; 
	background: #ffffff;
	color:000; 
	border: 1px #000000 solid;
	cursor: pointer;
}
</style>
 <link rel="stylesheet" href="${wapBase}/style/mobile/css/goods.css"/>
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
        (第${product.period }期)${product.name }<span style="color:red; display: block; font-size: 1.5rem;" title="${product.title}">${product.title}</span><span id="qishu"></span>
    </div>
   <div class="info ">
    <p class="price">
     <span style="float: right">总需${product.totalNum}人次</span> 总需：<b class="color01">${product.totalNum}</b>人次
    </p>
    <div class="progressBar">
     <p class="wrap-bar">
      <span class="bar" style="width: <fmt:formatNumber value="${product.usedNum/product.totalNum*100}" pattern="0.0#"/>%;"></span>
     </p>
     <div class="txt ui-clr">
      <span class="ui-left">${product.usedNum}人已参与</span> <span class="ui-right">剩余${product.leaveNum}人次</span>
     </div>
     <c:if test="${weixin_buy != '0'}">
	     <div class="txt ui-clr" style="background-color:#EFF8EF;padding: 10px 2px;width: 100%;">
	      	<p style="font-size: 1.5rem;color: red;font-weight: bold;">提示：会员进行商品购买需先充值积分，再使用积分进行兑换</p>
	      	<p>您当前积分余额为：<span style="font-size: 1.6rem;color: red;font-weight: bold;">${accountBalance}</span>积分</p>
	      	<p style="font-size: 1.6rem;color: red;font-weight: bold;padding: 5px 0;">点击充值积分：</p>
	      	<div>
	      		<a href="/member/buy/buyCheckIntegral?integral=${integral_price1 }" class="integral" >${integral_price1 }积分</a>
	      		<a href="/member/buy/buyCheckIntegral?integral=${integral_price2 }" class="integral" >${integral_price2 }积分</a>
	      		<a href="/member/buy/buyCheckIntegral?integral=${integral_price3 }" class="integral" >${integral_price3 }积分</a>
	      	</div>
	     </div>
     </c:if>
     
     <div class="bottom">
      参与人次：
      <div class="number" style="margin-right: 5px;">
       <input class="num-input" type="text" id="qty_${product.id}" data-max="${product.totalNum}" value="<c:if test="${product.leaveNum < 10 }">${product.leaveNum}</c:if><c:if test="${product.leaveNum > 9 }">10</c:if>" /> <a class="num-btn btn-plus" id="qty_plus" href="javascript:void(0);">+</a>
       <a class="num-btn btn-minus" id="qty_minus" href="javascript:void(0);">-</a>
       <a class="num-btn btn-last" href="javascript:void(0);" onclick="buyNum('${product.leaveNum}')">包尾</a>
	  </div>
      <script type="text/javascript">
							var need_num = '${product.totalNum}';
							function add() {
								var div = $(".num-input");
								var num = div.val();
								num = parseInt(num);
								num += 1;
								if (num > div.attr('data-max'))
									return false;
								div.val(num);
								getWinPoint(num, need_num);
							}
							function reduce() {
								var div = $(".num-input");
								var num = div.val();
								num = parseInt(num);
								num -= 1;
								if (num < 1)
									return false;
								div.val(num);
								getWinPoint(num, need_num);
							}
							function getWinPoint($num,$need_num){
							 layer.tips('获得机率 '+($num/$need_num*100).toFixed(2)+'%', '.num-input', {
							  tips: [1, '#f02d33'] //还可配置颜色
								});
							};
							function buyNum(num){
								$('.num-input').val(num);
								getWinPoint(num,need_num);
							}
						</script>
     </div>

     <div class="bottom">
      参与期数：
      <div class="number" style="margin-right: 5px;">
       <input class="qishu-input" type="text" id="qi_${product.id}" data-max="${totalPeriods}" value="1" /> <a class="num-btn btn-qishu-plus " id="qi_plus" href="javascript:void(0);">+</a>
       <a class="num-btn btn-qishu-minus " id="qi_minus" href="javascript:void(0);">-</a>
      </div>
      <span style="color: ##999">期
      </span>
      <script type="text/javascript">
							var need_qinum = '${totalPeriods}';
							function add_qi() {
								var div = $(".qishu-input");
								var num = div.val();
								num = parseInt(num);
								num += 1;
								if (num > div.attr('data-max'))
									return false;
								div.val(num);
								getQiPoint();
							}
							function reduce_qi() {
								var div = $(".qishu-input");
								var num = div.val();
								num = parseInt(num);
								num -= 1;
								if (num < 1)
									return false;
								div.val(num);
								getQiPoint();
							}

							function getQiPoint(){
							 layer.tips('系统自动分配多期位置', '.qishu-input', {
							  tips: [1, '#f02d33'] //还可配置颜色
								});
							};
							window.onload = function(e) {
								//鼠标按钮时刻，抬起时刻
								var firstTime, lastTime;
								//定义计时器(判断2s后)
								var time1, time2;
								//周期性计时器;
								var flag = false;
								document.getElementById("qi_plus").onmousedown = function(e) {
									firstTime = new Date().getTime();
									var time1 = setTimeout(function() {
										flag = true;
										clearTimeout(time1);
									}, 100);
									time2 = setInterval(function() {
										if (flag == true) {
											add_qi();
										}
									}, 100);
								}
								document.getElementById("qi_minus").onmousedown = function(e) {
									firstTime = new Date().getTime();
									var time1 = setTimeout(function() {
										flag = true;
										clearTimeout(time1);
									}, 100);
									time2 = setInterval(function() {
										if (flag == true) {
											reduce_qi();
										}
									}, 100);
								}

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
										if (e.target.id == "qi_plus") {
											add_qi();
											flag = false;
											clearInterval(time2);
										} else if (e.target.id == "qi_minus") {
											reduce_qi();
											flag = false;
											clearInterval(time2);
										} else if (e.target.id == "qty_plus") {
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
								$(".qishu-input").blur(function() {
									var max = $(this).attr('data-max') * 1;
									if ($(this).val() > max) {
										$(this).val(max);
									}
									if ($(this).val() < 1) {
										$(this).val(1);
									}
								});

								$(".num-input").blur(function() {
									var max = $(this).attr('data-max') * 1;
									if ($(this).val() > max) {
										$(this).val(max);
									}
									if ($(this).val() < 1) {
										$(this).val(1);
									}
									//getWinPoint($(this).val(), need_num);
								});
								//getWinPoint($(".num-input").val(), need_num);
							}
							function showme(){
								if (document.getElementById("hideme").innerText=="+更多..."){
										$('.box2').addClass('box2s');
										$('.box2').removeClass('box2');	
										document.getElementById("hideme").innerText="-收回...";
								}else{
										$('.box2s').addClass('box2');
										$('.box2s').removeClass('box2s');	
										document.getElementById("hideme").innerText="+更多...";	
								}
	
							}
						</script>
     </div>

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
     <c:when test="${myTotalBuyNums<99999}">
     <div class="box">
	 <div class="box2" onclick="showme();">
	   您本期总共参与了<b class="color01">${myTotalBuyNums }</b>人次
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	   &nbsp;&nbsp;&nbsp;&nbsp;<a href="javascript:void(0);" ><span style="align:right" id="hideme">+更多...</span ></a>
      <p class="codes">
       <span class="m-detail-code"> <c:forEach items="${myBuyRecords}" var="myBuyRecord">
         <c:forEach items="${fn:split(myBuyRecord.buyNos, ',')}" var="buyNo">
          <b>${buyNo }</b>
         </c:forEach>
        </c:forEach>
       </span>
      </p>
	  </div>
	  </div>
     </c:when>
     <c:otherwise>
     </c:otherwise>
    </c:choose>
   </div>
   <ul class="yunbuy_other">
   <c:if test="${product.storeId > 0 }">
   <a class="in_dianpu" href="/store/index/${product.storeId}">
            <img src="/assets/images/dianpu.png">
            <div class="dianpuinfo">
                <p class="dianpuming">
                    <b>  ${store.storeName} </b>
                    <br><b class="you_fahuo">由此商家提供发货，并提供售后服务</b>
                    <b class="you_fahuo color02" style="display: block;">进入商家店铺&gt;</b>
                </p>
            </div>
    </a>
	</c:if>
    <a href="/product/${product.id}/info"><img class="icon" src="${wapBase}/style/mobile/css_02/images/2.png" alt="">商品图文详情<label>（建议WIFI下使用）</label></a>
    <a href="/product/${product.id}/win"><img class="icon" src="${wapBase}/style/mobile/css_02/images/1.png" alt="">往期揭晓</a>
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
<%@ include file="/commons/taglibs.jsp"%>
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
   <a onclick="gotobuy()">立即兑换</a>
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
<!-- <%@ include file="/commons/commons_resource_foot.jsp"%> -->
 <%@ include file="/commons/index_wx.jsp"%>

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
	
	//立即兑换
	function gotobuy(){
		/* var weixin_buy = '${weixin_buy}';
		var accountBalance = '${accountBalance}'; 
		var qishu_input = $(".qishu-input").val();
		var num_input = $(".num-input").val();
		
		var pay_price = qishu_input*num_input;//支付金额
		if(weixin_buy == '0'){
			if(accountBalance < pay_price ){
				alert("抱歉，只能使用积分兑换，您的积分不足，请先购买积分")
			}else{
				addToCart('${product.id}','buy')
			}
		}else{
			addToCart('${product.id}','buy')
		}  */
		
		addToCart('${product.id}','buy');
	}

</script>
