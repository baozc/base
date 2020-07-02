<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="../commons/commons_resource_head.jsp"%>
 <title>购物车_${comName}</title>
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
 <h1>趣购订单</h1>
 <div class="back">
  <a class="ap-icon" href="javascript:history.back();"></a>
 </div>
 <div class="menu">
  <a class="icon-home ap-icon" href="/"></a>
 </div>
 </header>
 <style type="text/css">
.tips-m {
	background: #fff;
	padding: 15px 10px 5px;
	font-size: 1.4rem;
	color: #666;
}

.m-cart-address {
	font-size: 1.0rem;
}

.m-cart-address li {
	padding: 0 10px 0 0;
	margin-bottom: 5px;
	font-size: 1.2rem;
}

.m-cart-address li b {
	display: inline-block;
}

.m-cart-address li span {
	color: #666;
}

.m-cart-address li .address-edit {
	display: none;
}

.m-cart-address li.on {
	border: 1px solid #e54048;
	padding: 4px 10px 4px 10px;
	background: #FFF0E8;
	color: #333;
	box-shadow: 5px 5px 0 #F3F3F3;
	margin-bottom: 10px;
}

.m-cart-address li.on b {
	color: #f50;
	font-size: 1.2rem;
}
.pay_online {
	width:100px;
}
</style>
 <form action="/member/buy/integral_buy" id="checkoutFrom"  onsubmit="return validateForm()" method="get">
  <input type="hidden" name="token" value="a6baf2b45222bfd95b0a245376158e11" />
  <div id="content" class="container main">
   <div class="tips-m">
    <ul class="m-cart-address">
    </ul>
   </div>
   <div class="pay-list">
    <ul>
     <input type="hidden" name="integral" value="${totalPrice }" />
     <li class="ui-clr"><span class="name">积分商品购买</span>
  	 <span class="num"><em class="color">1</em>份</span></li>
    </ul>
   </div>
   <div class="order-total">
    商品合计：<strong style="font-size: 14px;">￥${totalPrice }</strong>
   </div>

   <div class="order-option">
    <div class="m-cart-order-pay checkBar">
     <div class="pay_online">
      <div data-pro="paySelector">
       <div class="w-pay" id="pro-view-2">
        <div class="w-pay-title">支付方式：</div>
        <div class="w-pay-selector">
		 <div style="float: left;display:none;" id="IweixinPay">
          <label class="w-pay-type w-pay-type-3  iwxpay"><input type="radio" name="payType" value="6" style="display: none;" ><img src="${wapBase}/style/images/wx.png" height="30px;"></label>
         </div>
         
         <div style="float: left;display:none;" id="PweixinPay">
          <label class="w-pay-type w-pay-type-3  pwxpay"><input type="radio" name="payType" value="5" style="display: none;" checked><img src="${wapBase}/style/images/wx.png" height="30px;"></label>
         </div>
         
		 <div style="float: left;" id="aliPay">
          <label class="w-pay-type w-pay-type-3  alipay"><input type="radio" name="payType" value="1" style="display: none;"><img src="${wapBase}/style/images/zfb.png" height="30px;"></label>
         </div>
                  
        </div>
       </div>
      </div>
     </div>
    </div>
   </div>
   <div class="order-submit">
    <button class="ap-button" type="submit" >确 认 支 付</button>
   </div>
  </div>
 </form>
 <script type="text/javascript">
 		var totalPrice=${totalPrice };
 		function validateForm(){
 			if($(".w-pay-selected")==null||$(".w-pay-selected")==undefined||$(".w-pay-selected").length==0){
 				layer.alert("请选择支付方式",0);
 				return false;
 			}else{
 				return true;
 			}
 		}
 		

		function is_weixn() {
			var ua = navigator.userAgent.toLowerCase();
			if (ua.match(/MicroMessenger/i) == "micromessenger") {
				return true;
			} else {
				return false;
			}
		}

		$(function() {
			$('.w-pay-selector').each(
					function() {
						var selector = $(this);
						selector.find('.w-pay-type').bind(
								'click',
								function() {
									$('.w-pay-selector').find('.w-pay-type').removeClass('w-pay-selected');
									$('.w-pay-selector').find('.w-pay-type').children('input[name=pay_id]').attr('checked', false);
									$(this).addClass('w-pay-selected');
									$(this).children('input[name=pay_id]').attr('checked', true);
									if ($(this).hasClass('teegon') == true) {
										$('.payment').empty();
										$('.payment').css('display', 'block');
										if (!is_weixn()) {
											$('.payment').append(
													"<input type='radio' name='payment_type' value='alipay_wap' checked style='display: inline'/>支付宝"
															+ "<input type='radio' name='payment_type' value='wxpay_jsapi' style='display: inline'/>微信支付");
										} else {
											$('.payment').append("<input type='radio' name='payment_type' value='wxpay_jsapi' checked style='display: inline'/>微信支付");
										}
									} else {
										$('.payment').empty();
										$('.payment').css('display', 'none');
									}
								});
					});

			if ($('.w-pay-selected').hasClass('teegon')) {
				$('.payment').empty();
				$('.payment').css('display', 'block');
				if (!is_weixn()) {
					$('.payment').append(
							"<input type='radio' name='payment_type' value='alipay_wap' checked style='display: inline'/>支付宝"
									+ "<input type='radio' name='payment_type' value='wxpay_jsapi' style='display: inline'/>微信支付");
				} else {
					$('.payment').append("<input type='radio' name='payment_type' value='wxpay_jsapi' checked style='display: inline'/>微信支付");
				}
			}
		});


	</script>
</body>
</html>
