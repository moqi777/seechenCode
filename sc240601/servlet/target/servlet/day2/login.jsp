<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        form {
            background-color: #ffffff;
            border: 1px solid #ddd;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 20px;
            width: 320px;
        }

        fieldset {
            border: none;
        }

        legend {
            font-size: 1.5em;
            margin-bottom: 10px;
        }

        p {
            margin-bottom: 15px;
        }

        input[type="text"],
        input[type="password"] {
            width: calc(100% - 22px);
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="checkbox"] {
            margin-right: 10px;
        }

        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 20px;
            text-align: center;
            text-decoration: none;
            display: inline-block;
            font-size: 16px;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<form action="/user?type=login" method="post" onsubmit="return check()">
    <fieldset>
        <legend>登录</legend>
        <p>账号：<input value="${cookie.userName.value}" name="phone" autocomplete="off" placeholder="请输入手机号/账号" type="text"></p>
        <p>密码：<input value="${cookie.password.value}" name="password" placeholder="请输入密码" type="password"></p>
        <div id="error" style="color: red"></div>
        <p><input name="remember" <c:if test="${cookie.password.value!=''}">checked="checked"</c:if> type="checkbox" value="1"/>记住密码</p>
        <button type="submit">登录</button>
    </fieldset>
</form>
</body>
<script>
    var check = () => {
        let phone = document.getElementsByName("phone")[0].value;
        let password = document.getElementsByName("password")[0].value;
        let error = document.getElementById("error");
        if(phone == ""){
            error.innerText="账号为空";
            return false;
        }
        let phoneReg = /^[\u4e00-\u9fa5_A-Za-z0-9]+$/;
        if(!phoneReg.test(phone)){
            error.innerText = "账号格式错误";
            return false;
        }
        if(phone.length>11){
            error.innerText = "账号长度超过11位";
            return false;
        }
        if(password == ""){
            error.innerText="密码为空";
            return false;
        }
        return true;
    }
</script>
</html>
