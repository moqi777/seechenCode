<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/8/20
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
</head>
<body>
请输入ID：<input id="showId">
<button onclick="show()">查询</button>
<button onclick="del()">删除</button>
<br>
<br>
结果：<textarea id="text"></textarea>
</body>
<script>
    let show = ()=>{
        var value = document.getElementById("showId").value;
        axios.post("http://localhost:8080/showById",{id:value}).then(res=>{
            console.log(res.data)
            document.getElementById("text").value=res.data.msg+"\n"+res.data.data;
        })
    }
    let del = () =>{
        var value = document.getElementById("showId").value;
        axios.post("http://localhost:8080/delById",{id:value}).then(res=>{
            console.log(res.data)
            document.getElementById("text").value=res.data.msg;
        })
    }
</script>
</html>
