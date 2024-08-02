<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
姓名：${userMvc.name} 存款：${userMvc.money}<br>
req:${req}<br>
m1:${m1}<br>
m2:${m2}<br>
m3:${m3}<br>
session：${session}<br>
application：${application}<br>
<a href="/day1/add.jsp">新增</a> <button>批量删除</button>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <th><input type="checkbox">全选</th>
            <th>编号</th>
            <th>姓名</th>
            <th>存款</th>
            <th>生日</th>
            <th>头像</th>
            <th>操作</th>
        </tr>
        <c:forEach var="u" items="${list}">
            <tr>
                <td><input type="checkbox"></td>
                <td>${u.id}</td>
                <td><a href="#">${u.name}</a></td>
                <td>${u.money}</td>
                <td>${u.time}</td>
                <c:if test="${empty u.head}">
                    <td><img src="https://s2.loli.net/2024/08/02/MgH2iNkdstCPQKB.webp" alt="" style="width: 25px;height: 25px;"></td>
                </c:if>
                <c:if test="${not empty u.head}">
                    <td><img src="/upload/${u.head}" alt="" style="width: 25px;height: 25px;"></td>
                </c:if>
                <td><a href="#">删除</a> </td>
            </tr>
        </c:forEach>
    </table>
[当前页数/总页数]
<a href="#">首页</a>
<a href="#">上一页</a>
1 2 3 4 5
<a href="#">下一页</a>
<a href="#">尾页</a>
<input type="text" size="1">页<button>跳转</button>
每页条数
<select>
    <option>3</option>
    <option>6</option>
    <option>9</option>
</select>
</body>
</html>
