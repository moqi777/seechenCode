<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/7/25
  Time: 19:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>新增用户</title>
</head>
<body>
<%--点击确认后经过控制层再次返回回来，对返回的值判断一下--%>
<c:if test="${addStatus == 1}">
    <script>
        alert("新增成功")
        window.location.href = "/user?type=userShow";
    </script>
</c:if>
<c:if test="${addStatus == 0}">
    <script>
        alert("新增失败")
        window.location.href = "/user?type=userShow";
    </script>
</c:if>
<div id="error" style="color: red"></div>
<form action="/user?type=addUser" method="post" onsubmit="return check()">
    <fieldset>
        <legend>新增用户</legend>
        <p>账号：<input name="phone" autocomplete="off" placeholder="请输入手机号/账号" type="text"></p>
        <p>密码：<input name="password" placeholder="请输入密码" type="password"></p>
        <p>确认密码：<input name="password2" placeholder="请输入确认密码" type="password"></p>
        <p>充值：<input name="money" placeholder="请充值金额" type="text"></p>
        <p>套餐：<select name="serviceId">
            <option value="0">超人套餐</option>
            <option value="1">网虫套餐</option>
            <option value="2">话痨套餐</option>
        </select></p>
        <button type="submit">确认</button>
    </fieldset>
</form>
</body>
<script>
    //确保表单里的账号 密码 余额输入的符合规则
    //满足规则：return true 否则 false
    var check = ()=>{
        //1.先获取表单组件对象（文本框对象 .. 密码框对象）
        //2.通过组件对象获取里面的值
        let phone = document.getElementsByName("phone")[0].value;
        let password = document.getElementsByName("password")[0].value;
        let password2 = document.getElementsByName("password2")[0].value;
        let money = document.getElementsByName("money")[0].value;
        let error = document.getElementById("error");
        if(phone==""){
            //提示
            error.innerText = "账号为空";
            return false;//不能提交
        }
        //1.定义正则表达式（百度搜，前后记得加斜杠）
        let phoneReg = /^[A-Za-z0-9]+$/;
        //2.验证正则表达式
        if (!phoneReg.test(phone)){
            error.innerText = "账号只能由字母和数字构成";
            return false;
        }
        if(password==""){
            //提示
            error.innerText = "密码为空";
            return false;//不能提交
        }
        if(password2==""){
            //提示
            error.innerText = "确认密码为空";
            return false;//不能提交
        }
        if(password != password2){
            error.innerText = "两次密码不一致";
            return false;
        }
        let moneyRey = /^[1-9]d*.d*|0.d*[1-9]d*$/;
        if (!moneyRey.test(money)){
            error.innerText = "错误金额";
            return false;
        }
        return true;//可以提交
    }
</script>
</html>
