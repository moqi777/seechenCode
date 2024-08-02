<%@ page import="pojo.User" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    User user = (User)session.getAttribute("user");
    request.setAttribute("user",user);
%>
<table border="1px" width="400px"cellspacing="0px" cellpadding="5px"  align="center">
    <caption>用户信息</caption>
    <tr align="center">
        <td>ID</td>
        <td>${user.id}</td>
    </tr>
    <tr align="center">
        <td>phone</td>
        <td>${user.phone}</td>
    </tr>
    <tr align="center">
        <td>password</td>
        <td>${user.password}</td>
    </tr>
    <tr align="center">
        <td>money</td>
        <td>${user.money}</td>
    </tr>
    <tr align="center">
        <td>serviceId</td>
        <td>${user.serviceId}</td>
    </tr></table>
</body>
</html>
