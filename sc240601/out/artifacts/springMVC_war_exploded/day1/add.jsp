<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/8/1
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<form action="/usermvc/add" method="post">
    <p>姓名：<input name="name"></p>
    <p>存款：<input name="money"></p>
    <p>生日：<input type="date" name="time"></p>
    <%--<p>头像：<input name=""></p>--%>
    <button type="submit">新增</button>
</form>
</body>
</html>
