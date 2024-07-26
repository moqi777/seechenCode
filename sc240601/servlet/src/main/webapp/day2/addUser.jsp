<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/25
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<%--点击确认后经过控制层再次返回回来，对返回的值判断一下--%>
<c:if test="${addStatus == 1}">
    <script>
        alert("新增成功")
        window.location.href = "/user?type=userShow";
    </script>
</c:if>
<c:if test="${addStatus == 0}">
    <script>
        alert("新增失败")
        window.location.href = "/user?type=userShow";
    </script>
</c:if>

<form action="/user?type=addUser" method="post">
    <fieldset>
        <legend>新增用户</legend>
        <p>账号：<input name="phone" autocomplete="off" placeholder="请输入手机号/账号" type="text"></p>
        <p>密码：<input name="password" placeholder="请输入密码" type="password"></p>
        <p>充值：<input name="money" placeholder="请充值金额" type="text"></p>
        <p>套餐：<select name="serviceId">
            <option value="0">超人套餐</option>
            <option value="1">网虫套餐</option>
            <option value="2">话痨套餐</option>
        </select></p>
        <button type="submit">确认</button>
    </fieldset>
</form>
</body>
</html>
