<%@page contentType="text/html; charset=utf-8" %>
<html>
<body>
<h2>Hello World!</h2>
<form action="/add" method="post">
    <p>姓名：<input name="name"/></p>
    <p>余额：<input name="moeny"/></p>
    <p>生日：<input name="time"/></p>
    <button>提交</button>
</form>
<a href="/add">新增</a>
<a href="/login">登录</a>
<a href="/del">删除</a>
</body>
</html>
