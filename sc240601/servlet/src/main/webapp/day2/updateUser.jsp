<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/25
  Time: 20:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>修改用户信息</title>
</head>
<body>
<%--点击确认后经过控制层再次返回回来，对返回的值判断一下--%>
<c:if test="${updateStatus == 1}">
    <script>
        alert("修改成功")
        window.location.href = "/user?type=userShow";
    </script>
</c:if>
<c:if test="${updateStatus == 0}">
    <script>
        alert("修改失败")
        window.location.href = "/user?type=userShow";
    </script>
</c:if>

<c:set var="id" value="${param.id}" />
<c:set var="phone" value="${param.phone}" />
<c:set var="password" value="${param.password}" />
<c:set var="money" value="${param.money}" />
<c:set var="serviceId" value="${param.serviceId}" />

<form action="/user?type=updateUser" method="post">
    <fieldset>
        <legend>修改用户</legend>
        <p>ID：<input name="id" type="text" value="${id}" readonly="true"></p>
        <p>账号：<input name="phone" autocomplete="off" value="${phone}" type="text"></p>
        <p>密码：<input name="password" value="${password}" type="password"></p>
        <p>充值：<input name="money" value="${money}" type="text"></p>
        <p>套餐：<select name="serviceId">
            <option value="0" <c:if test="${serviceId == '0'}">selected</c:if>>超人套餐</option>
            <option value="1" <c:if test="${serviceId == '1'}">selected</c:if>>网虫套餐</option>
            <option value="2" <c:if test="${serviceId == '2'}">selected</c:if>>话痨套餐</option>
        </select></p>
        <button type="submit">确认</button>
    </fieldset>
</form>
</body>
</html>
