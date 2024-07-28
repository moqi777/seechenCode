<%@ page import="pojo.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/25
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>

        .isExit {
            width: 400px;
            height: 200px;
            background-color: #ffffff;
            border: 2px solid #ddd;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            position: absolute;
            top: 30%;
            left: 50%;
            transform: translate(-50%, -50%);
            text-align: center;
            display: none;
            padding: 20px;
        }

        .isExit h1 {
            font-size: 24px;
            margin-bottom: 20px;
            color: #333;
        }

        .isExit button {
            padding: 10px 20px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }

        .isExit button:nth-child(1) {
            background-color: #ff4d4d;
            color: #fff;
        }

        .isExit button:nth-child(2) {
            background-color: #4caf50;
            color: #fff;
        }

        .isExit button:hover {
            opacity: 0.9;
        }
    </style>
</head>
<body>
<h3>
    <c:set var="loginUser" value="${sessionScope.loginUser}" />
    欢迎${loginUser.phone}登录，套餐：
    <c:if test="${loginUser.serviceId==0}">超人套餐</c:if>
    <c:if test="${loginUser.serviceId==1}">网虫套餐</c:if>
    <c:if test="${loginUser.serviceId==2}">话痨套餐</c:if>
    ，余额：${loginUser.money}
    <button onclick="isExit()">退出登录</button>
</h3>
<ul>
    <li><a target="children" href="/user?type=userShow">用户管理</a></li>
    <li><a target="children" href="/day2/serviceShow.jsp">套餐管理</a></li>
    <li><a target="children" href="#">消息管理</a></li>
    <li><a target="children" href="#">文章管理</a></li>
</ul>
<%--内联框架 可以包含其他子页面--%>
<iframe name="children" style="position: absolute;top: 50px;left: 150px" width="600"
        height="300" frameborder="1" src="index.jsp"></iframe>
<div class="isExit">
    <h1>确认退出吗？</h1>
    <button onclick="yesExit()">确认</button>&nbsp;&nbsp;&nbsp;&nbsp;
    <button onclick="noExit()">取消</button>
</div>
</body>
<script>
    function isExit() {
        document.querySelector(".isExit").style.display="block";
    }
    function noExit() {
        document.querySelector(".isExit").style.display="none";
    }
    function yesExit() {
        window.location.href="/user?type=exit";
    }
</script>
</html>
