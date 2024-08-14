<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/8/13
  Time: 16:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <th>编号</th>
        <th>姓名</th>
        <th>时间</th>
        <th>积分</th>
        <th>性别</th>
    </tr>
    <c:forEach var="u" items="${p.list}">
        <tr>
            <th>${u.id}</th>
            <th>${u.name}</th>
            <th>${u.regtime}</th>
            <th>${u.integral}</th>
            <th>${u.sex}</th>
        </tr>
    </c:forEach>
</table>
<a href="/page?currentIndex=1"}>首页</a>
<a href="/page?currentIndex=${p.prePage}">上一页</a>
<c:forEach var="i" items="${p.navigatepageNums}">
    <a href="/page?currentIndex=${i}">${i}</a>
</c:forEach>
<a href="/page?currentIndex=${p.nextPage}">下一页</a>
<a href="/page?currentIndex=${p.pages}">尾页</a>
</body>
</html>
