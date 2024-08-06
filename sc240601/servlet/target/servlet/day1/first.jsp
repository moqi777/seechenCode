<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList" %>
<%-- 第一行必须是page指令 --%>
<%--设置isELIgnored不忽视EL表达式--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //脚本语言：会被servlet取代
    //任意的java代码
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");
    //把list存储到一个作用域(request作用域)
    //存储的方式类似于map集合
    request.setAttribute("list",list);
%>
<%--
    jstl中的foreach标签 可以遍历servlet存储好(作用域)的数据
    c:forEach类似于增强for
    for(类型 临时名:集合或数组){}
--%>
<c:forEach var="l" items="${list}">
    <li>${l}</li>
</c:forEach>
</body>
</html>
