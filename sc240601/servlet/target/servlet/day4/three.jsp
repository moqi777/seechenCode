<%@ page import="java.io.FileReader" %>
<%@ page import="java.io.BufferedReader" %><%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/30
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>session丢失了 我要通过sessionID还原</h3>
<%
    FileReader fr = new FileReader("D:\\NewStudy\\session.txt");
    BufferedReader br = new BufferedReader(fr);
    String sessionId = br.readLine();
    //存储sessionId不能乱写 key是固定名称：JSESSIONID
    Cookie c = new Cookie("JSESSIONID", sessionId);
    response.addCookie(c);
%>
</body>
</html>
