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
<h3>getScope：${page}</h3>
<h3>getScope：${request}</h3>
<h3>getScope：${session}</h3>
<h3>getScope：${application}</h3>
</body>
<script>
    var str = ${page};
    console.log(str);
</script>
</html>
