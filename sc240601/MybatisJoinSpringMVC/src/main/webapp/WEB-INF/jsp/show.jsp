<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/8/8
  Time: 19:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>展示</title>
</head>
<style>
    #add{
        width: 400px;
        height: 400px;
        background-color: white;
        border: 1px solid black;
        align-content: center;
        align-items: center;
        padding-left: 100px;
        display: none;
        position: absolute;
        top: 20%;
        left: 30%;
    }
</style>
<body>
<button type="button" onclick="del()">删除所选</button>
<button type="button" onclick="add()">新增</button>
<div id="add">
    <h1>新增用户</h1>
    <form action="/huser/add" method="post">
        <p>用户名：<input type="text" name="username"></p>
        <p>密码：<input type="password" name="password"></p>
        <p>年龄：<input name="info.age"></p>
        <p>
            性别：<select name="info.sex">
                <option value="1">男</option>
                <option value="0">女</option>
            </select>
        </p>
        <p>
            部门：<select name="did">
            <option value="1">技术部</option>
            <option value="2">体育部</option>
            <option value="3">项目部</option>
        </select>
        </p>
        <button type="submit" onclick="this.style='display: none'">提交</button>
    </form>
</div>
<table border="1px" cellspacing="0px" cellpadding="5px">
    <tr>
        <td><input type="checkbox" onchange="checkAll(this)"></td>
        <td>用户编号</td>
        <td>账号</td>
        <td>密码</td>
        <td>时间</td>
        <td>性别</td>
        <td>年龄</td>
        <td>部门名称</td>
    </tr>
    <form action="/huser/del" method="post" id="delFome">
        <c:forEach items="${list}" var="huser">
            <tr>
                <td><input type="checkbox" name="check" value="${huser.id}"></td>
                <td>${huser.id}</td>
                <td>${huser.username}</td>
                <td>${huser.password}</td>
                <td><fmt:formatDate value="${huser.createtime}" pattern="yyyy-MM-dd"/></td>
                <td>${huser.info.sex}</td>
                <td>${huser.info.age}</td>
                <td>${huser.dept.deptname}</td>
            </tr>
        </c:forEach>
    </form>
</table>
</body>
<script>
    let add = ()=>{
        document.getElementById("add").style="display:block;";
    }
    let checkAll = (checkAll)=>{
        let check = document.getElementsByName("check");
        check.forEach(value => {
            if (checkAll.checked==true){
                value.checked=true;
            }else {
                value.checked=false;
            }
        })
    }
    let del = ()=>{
        let delFome = document.getElementById("delFome");
        delFome.submit();
    }
</script>
</html>
