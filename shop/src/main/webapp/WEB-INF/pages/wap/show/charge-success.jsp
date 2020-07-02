<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/commons/taglibs.jsp"%>
    <title>提交投诉</title>
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, user-scalable=no">
    <link rel="stylesheet" href="${wapBase}/style/charge/css/charge.css">
    <link rel="stylesheet" href="${wapBase}/style/charge/css/reset.css">
    <script src="${wapBase}/style/charge/js/jquery.min.js"></script>
</head>
<body>
    <div>
        <img class="charge-success" src="${wapBase}/style/charge/images/success.png" alt="">
    </div>

    <div class="suceess">投诉成功!</div>

    <p style="text-align: center; color: #ACACAC; margin-bottom:30px">我们已经收到您的反馈, 会尽快为您处理.</p>
    
    <a href="/">
        <input type="button" class="charge-submit" id="charge-submit" value="完成">
    </a>

</body>
</html>