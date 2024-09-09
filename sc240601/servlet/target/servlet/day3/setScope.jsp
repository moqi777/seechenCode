<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/26
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //page作用域
    pageContext.setAttribute("page","pageValue");
    //request作用域
    request.setAttribute("request","resuestValue");
    //session作用域
    session.setAttribute("session","sessionValue");
    //application作用域
    application.setAttribute("application","applicationValue");
%>
<h3>setScope：${page}</h3>
<%--引入getScope页面--%>
<%
    pageContext.include("getScope.jsp");
%>
<script>
    var str = '${page}';
    console.log(str);
</script>
</body>
</html>
