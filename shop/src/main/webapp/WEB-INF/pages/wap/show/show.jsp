<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=Edge">
 <%@ include file="/commons/commons_resource_head.jsp"%>
 <title>入住必读_${comName}</title>
 <meta charset="utf-8">
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=2,user-scalable=no">
   <link rel="stylesheet" href="${wapBase}/style/mobile/css/common_jiexiao.css">
    <link rel="stylesheet" href="${wapBase}/style/mobile/css/font/iconfont.css">
	<script type="text/javascript">
        var apiUrl = "";
    </script>
     <script src="${wapBase}/style/jquery-1.8.3.min.js"></script>
     <script type="text/javascript" src="${wapBase}/style/layer/layer.min.js"></script>
     <script type="text/javascript" src="${wapBase}/style/common.js"></script>
	 <script src="${wapBase}/js/lefttime_jx.js"></script>
</head>
<body>

 <style type="text/css">
    .count{ background: #fff;font-size: 24px;color: #f02d33; display: inline-block;margin-top: 8px;}

    .count b{ color: #f02d33; }
    .icon-count:after{ color: #f02d33; font-size: 28px;margin-top: 8px;}
    .timeago{
        display: block;
        position: absolute;
        width: 110px;
        bottom:0;
        text-align: center;
        background-color: #454545;
        opacity: 0.8;
        color: #ffffff;
    }
    .goodList .pic{ margin-top: 1px; }
    .buynext{  margin-top: -15px; }
    .info .itemP{ padding: 5px 0px;  }
    .ui-clr .pic{ max-height: 100px;overflow: hidden; }
.pagecontent {
    width: 96%;
    margin: auto;
    line-height: 30px;
    font-size: 16px;
    color: #666666;
    margin-top: 10px;
}
 .backlist .b {
    display: block;
    line-height: 25px;
    width: 90%;
    margin: auto;
    text-align: center;
    padding: 10px 0px;
}   
    .shareList .title{ padding-bottom: 0px; margin-bottom:0px; }
</style>
 <div class="container">
   <div class="fn-clear mt20 pb20">
    <div class="fn-right hy-r">
     <div class="fn-clear hy-tjxh">
      <div class="title">
      </div>
      <div class="hy-box">
       <div class="pagecontent" >
京都钓具:<br/>
全国实体渔具店，钓场，网店。<br/>
平台客服微信：ZLJDDJ，jun13111670562<br/>
一：针对以下商品进行不予通过。<br/>
1，  红包，购物卡，点券，充值卡，话费。<br/>
2，  烟草，酒水，食品，非渔具商品等。<br/>
3，  各种国家违禁品等。<br/>
4,   禁止商家私下返还现金等赌博行为。<br/>
5,   商品必须大于50元，小于5000元。<br/>
 
二：平台免费提供商家入驻，简单快捷（注册商家请加客服微信号，备注店铺名称，商品极速审核通过在平台展示）<br/>
三：入驻商户请提供清晰的身份证照片正反面，商铺门头照，售卖商品照和营业执照。<br/>
四：平台商家每天固定提现时间为每日晚申请到账时间24小时内（具体详情请联系客服）<br/>
五：平台收取每笔订单的12%（100收12）的费用，用来优化平台的各个项目的费用，谢谢合作！<br/>
 
二：平台免费提供商家入驻，简单快捷（注册商家请加客服微信号，备注店铺名称，商品极速审核通过在平台展示）<br/>
三：平台商家每天固定提现时间为每日下午6点（具体详情请联系客服）<br/>
四：平台会收取每笔订单的12%（100收12）的费用，用来优化平台的各个项目的费用，谢谢合作！<br/>
 
 
      </div>
     </div>
    </div>
   </div>
 </div>
 <!--  公共底部 -->
 <c:set var="footType" value="index" />
 <%@ include file="/index/index_foot.jsp"%>
 <!--  公共底部 -->
</body>
</html>
