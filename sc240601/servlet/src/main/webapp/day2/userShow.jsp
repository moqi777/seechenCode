<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/25
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<h3>用户管理</h3>

<a href="/day2/addUser.jsp">新增</a>
<table width="100%" cellspacing="0" cellpadding="10" border="1">
    <tr>
        <th>编号</th>
        <th>账号</th>
        <th>密码</th>
        <th>余额</th>
        <th>外键</th>
        <th>操作</th>
    </tr>
    <c:forEach var="u" items="${userList}">
        <tr>
<%--            href="javascript:void(0);"：阻止点击跳转，但是又保留了a标签的可点击性--%>
            <th><a href="javascript:void(0);" onclick="updateUser(event,this)">${u.id}</a></th>
            <th>${u.phone}</th>
            <th>${u.password}</th>
            <th>${u.money}</th>
            <th>${u.serviceId}</th>
            <th><button class="del" onclick="deleteUser(this)">删除</button></th>
        </tr>
    </c:forEach>
</table>
</body>
<script>
    function deleteUser(button) {
        var row = button.parentNode.parentNode;
        var firstTh = row.querySelector('th');
        var id = firstTh.innerText;
        window.location.href = "/user?type=deleteUser&id="+id;
    }
    function updateUser(event,button){
        //允许a标签跳转了
        //event.preventDefault();

        var row = button.parentNode.parentNode; // 获取当前行
        var cells = row.children; // 获取当前行的所有单元格

        var id = cells[0].innerText;
        var phone = cells[1].innerText;
        var password = cells[2].innerText;
        var money = cells[3].innerText;
        var serviceId = cells[4].innerText;

        window.location.href = "/day2/updateUser.jsp?id=" + encodeURIComponent(id) +
            "&phone=" + encodeURIComponent(phone) +
            "&password=" + encodeURIComponent(password) +
            "&money=" + encodeURIComponent(money) +
            "&serviceId=" + encodeURIComponent(serviceId);
    }
</script>
</html>
