<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<h3>用户注册</h3>
<%--提交数据的任何都可以做 from a js--%>
<form action="/day1/reg_controller.jsp" method="get">
    <p>账号：<input type="text" name="phone"></p>
    <p>密码：<input type="password" name="password"></p>
    <p>充值：<input type="text" name="maney"></p>
    <p>套餐：
        <select name="serviceId">
            <option value="0">超人套餐</option>
            <option value="1">话痨套餐</option>
            <option value="2">网虫套餐</option>
        </select>
    </p>
    <button type="submit">注册</button>
</form>
</body>
</html>
