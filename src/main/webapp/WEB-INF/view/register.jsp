<%--
  Created by IntelliJ IDEA.
  User: thinkpad
  Date: 2018/6/3
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
</head>
<body style="font-size: 32px">
<form id="form-register">
    <fieldset>
        <legend>用户注册</legend>
        用户名：<input type="text" name="username" id="uname"/><br/>
        密码：<input type="password" name="password"/><br/>
        邮箱：<input type="text" name="email" id="email"/><br/>
        电话：<input type="text" name="cellphone" id="cellphone"/><br/>
        <a href="javascript:void(0);" id="reg-btn">注册</a>
    </fieldset>
</form>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/messages_zh.js"></script>
<script>
    $(document).ready(function () {
        validator = $("#form-register").validate({
            debug: true,
            rules: {
                username: {
                    required: true,
                    minlength: 10
                },
                password: {
                    required: true,
                    minlength: 8
                },
                email: {
                    required: true,
                },
                cellphone: {
                    required: true,
                }
            },
            messages: {
                username: {
                    required: "请输入用户名",
                    minlength: "请输入至少十个字符"
                },
                password: {
                    required: "请输入密码",
                    minlength: "请输入至少八位字符"
                },
                email: {
                    required: "请输入邮箱"
                },
                cellphone: {
                    required: "请输入电话"
                }
            }
        });

        $("#reg-btn").click(function () {
            $.ajax({
                "url": "${pageContext.request.contextPath}/user/register",
                "data": $("#form-register").serialize(),
                "type": "POST",
                "success": function (resp) {
                    if (resp.state == 1000) {
                        //登录页面
                        location.href = "${pageContext.request.contextPath}/user/login";
                    } else {
                        alert(resp.msg);
                    }
                }
            });
        });
    });

</script>
</body>
</html>
