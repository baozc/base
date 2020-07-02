<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <%@ include file="/commons/commons_resource_head.jsp" %>
    <title>最新揭晓_${comName}</title>
    <meta charset="utf-8">
    <meta name="keywords" content=""/>
    <meta name="description" content=""/>
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
    <script type="text/javascript">
        var href = "http://iarvb.cn/win.php";
        var title = "最新揭晓_${comName}";
    </script>
    <%@ include file="/commons/index_wx.jsp" %>
</head>
<body>

<style type="text/css">
    .count {
        background: #fff;
        font-size: 24px;
        color: #f02d33;
        display: inline-block;
        margin-top: 8px;
    }

    .count b {
        color: #f02d33;
    }

    .icon-count:after {
        color: #f02d33;
        font-size: 28px;
        margin-top: 8px;
    }

    .timeago {
        display: block;
        position: absolute;
        width: 110px;
        bottom: 0;
        text-align: center;
        background-color: #454545;
        opacity: 0.8;
        color: #ffffff;
    }

    .goodList .pic {
        margin-top: 1px;
    }

    .buynext {
        margin-top: -15px;
    }

    .info .itemP {
        padding: 5px 0px;
    }

    .ui-clr .pic {
        max-height: 100px;
        overflow: hidden;
    }

    .shareList .title {
        padding-bottom: 0px;
        margin-bottom: 0px;
    }
</style>
<div class="container">
    <!--  公共头部 -->
    <c:set var="headType" value="zxjx"/>
    <%@ include file="/index/index_head.jsp" %>
    <!--  公共头部 -->
    <div class="clear"></div>
    <div class="pro-view shareList">
        <ul class="goodList" id="win-list">
            <li class="item ui-clr item-db"></li>
        </ul>
    </div>
</div>
<input type="hidden" name="ids" id="ids" value=""/>
<!--  公共底部 -->
<c:set var="footType" value="win"/>
<%@ include file="/index/index_foot.jsp" %>
<!--  公共底部 -->
</body>
</html>
<script src="${wapBase}/style/mobile/js/jquery.more.js"></script>
<script type="text/javascript">
    $(function () {
        $('.goodList').more({
            'address': '/wap/win',
            'amount': 10
        })
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        // compaceIds('mobile');
        // setInterval(function () {
        //     compaceIds('mobile');
        // }, ids_time * 1000);
    });

</script>
${html}