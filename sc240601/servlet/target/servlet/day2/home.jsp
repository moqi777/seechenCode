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
</head>
<body>
<h3>
    <c:set var="loginUser" value="${param.loginUser}" scope="session"/>
    欢迎${loginUser.phone}登录，套餐：${loginUser.serviceId}，余额：${loginUser.money}
    <a href="/day2/login.jsp">登录退出</a>
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
</body>
</html>
