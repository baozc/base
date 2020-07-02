<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div class="new-foot1"></div>
<ul class="new-foot">
 <li><a href="/" <c:if test="${not empty footType and footType eq 'index' }">class="hover"</c:if>> <em><i class="iconfont icon-zhuye"></i></em>
   <p>首页</p>
 </a></li>
<%--  <li><a href="/product" <c:if test="${not empty footType and footType eq 'product' }">class="hover"</c:if>> <em><i class="iconfont icon-gouwuche"></i></em>
   <p>分类</p>
 </a></li>
 <li><a href="/win" <c:if test="${not empty footType and footType eq 'win' }">class="hover"</c:if>> <em><i class="iconfont icon-sfsiconyidongduankaijiang"></i></em>
   <p>最新揭晓</p>
 </a></li> --%>
 <li><a href="/member" <c:if test="${not empty footType and footType eq 'member' }">class="hover"</c:if>> <em><i class="iconfont icon-01huiyuanzhongxin"></i></em>
   <p>我的</p>
 </a></li>
 <li class="duihuan_d liji">
   <a href="/member/order/sendOrder/onekey.php" >一键发货</a>
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
<script src="${wapBase}/style/mobile/js/script.js"></script>
<div style="display: none"></div>
<script type="text/javascript">
	/*var tjtag = document.createElement('script');
	tjtag.src = 'admin/js/statistic.js';
	tjtag.type = 'text/javascript';
	document.body.appendChild(tjtag);*/
</script>
<%@ include file="../commons/commons_resource_foot.jsp"%>
