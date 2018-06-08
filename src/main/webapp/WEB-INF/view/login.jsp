<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/6/6
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
</head>
<body style="font-size: 32px">
<form id="form-login">
    <fieldset>
        <legend>用户登录</legend>
        用户名：<input type="text" name="username" id="username"><br />
        密码：<input type="password" name="password" id="password"><br />
        <a href="javascript:void(0);" id="log-btn">登录</a>
    </fieldset>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js"></script>
<script>
    $("#log-btn").click(function () {
        $.ajax({
            "url": "${pageContext.request.contextPath}/user/login",
            "data": $("#form-login").serialize(),
            "type": "POST",
            "success": function (resp) {
                if (resp.state == 1000) {
                    //登录成功页面
                    location.href = "${pageContext.request.contextPath}/user/success";
                } else {
                    alert(resp.msg);
                }
            }
        });
    });
</script>
</body>
</html>
