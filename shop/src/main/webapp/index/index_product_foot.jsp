<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/commons/taglibs.jsp"%>
<div class="new-foot1"></div>
<ul class="new-foot">
 <li><a href="/" <c:if test="${not empty footType and footType eq 'index' }">class="hover"</c:if>> <em><i class="iconfont icon-zhuye"></i></em>
   <p>首页</p>
 </a></li>
<%--  <li><a href="/product" <c:if test="${not empty footType and footType eq 'product' }">class="hover"</c:if>> <em><i class="iconfont icon-yiyuangoujilu"></i></em>
   <p>分类</p>
 </a></li>
 <li><a href="/win" <c:if test="${not empty footType and footType eq 'win' }">class="hover"</c:if>> <em><i class="iconfont icon-sfsiconyidongduankaijiang"></i></em>
   <p>最新揭晓</p>
 </a></li> --%>
 <li><a href="/member" <c:if test="${not empty footType and footType eq 'member' }">class="hover"</c:if>> <em><i class="iconfont icon-01huiyuanzhongxin"></i></em>
   <p>我的</p>
 </a></li>
<li class="duihuan_d liji">
   <a href="/member/login">立即兑换</a>
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

</style>
<%@ include file="../commons/commons_resource_foot.jsp"%>
