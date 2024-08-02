<%@ page import="java.io.FileOutputStream" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/30
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>负责创建session作用域的数据</h1>
<%
    session.setAttribute("msg",new Date());
    //关闭浏览器 sessionId就没了 所以可以保存起来这个id
    String sessionId = session.getId();
    FileOutputStream fos = new FileOutputStream("D:\\NewStudy\\session.txt");
    fos.write(sessionId.getBytes());
%>
</body>
</html>
