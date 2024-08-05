<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .num{
            display: inline-block;
            width: 20px;
            height: 20px;
            border: 1px solid red;
            text-align: center;
            line-height: 20px;
            border-radius: 50px;
        }
    </style>
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
        <c:forEach var="u" items="${p.list}">
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
                <td>
                    <a href="#">删除</a>
                    <a href="/usermvc/download?fileName=${empty u.head?'https://s2.loli.net/2024/08/02/MgH2iNkdstCPQKB.webp':u.head}"}>下载</a>
                </td>
            </tr>
        </c:forEach>
    </table>
[${p.currentIndex}/${p.totalPage}]

<c:if test="${p.currentIndex>1}">
<a href="/usermvc/show?currentIndex=1">首页</a>
<a href="/usermvc/show?currentIndex=${p.currentIndex-1}">上一页</a>
</c:if>
<c:if test="${p.currentIndex==1}">
<a href="javascript:void(0)">首页</a>
<a href="javascript:void(0)">上一页</a>
</c:if>

<%--等价于标准for循环--%>
<c:forEach var="i" begin="1" end="${p.totalPage}">
    <a class="num" <c:if test="${p.currentIndex==i}">style="background-color: greenyellow"</c:if> href="/usermvc/show?currentIndex=${i}">${i}</a>
</c:forEach>

<c:if test="${p.currentIndex<p.totalPage}">
<a href="/usermvc/show?currentIndex=${p.currentIndex+1}">下一页</a>
<a href="/usermvc/show?currentIndex=${p.totalPage}">尾页</a>
</c:if>
<c:if test="${p.currentIndex==p.totalPage}">
<a href="javascript:void(0)">下一页</a>
<a href="javascript:void(0)">尾页</a>
</c:if>

<input id="page" type="text" size="1">页<button onclick="clickPage()">跳转</button>
每页条数
<select onchange="change(this)">
    <c:forEach var="i" begin="3" end="9" step="3">
        <option <c:if test="${p.pageSize==i}">selected</c:if>>${i}</option>
    </c:forEach>
</select>
</body>
<script>
    let clickPage = ()=>{
        let page = document.getElementById("page").value;
        //判断页码数小于1 或者 页码数 输入的不是数字
        if (page < 1 || isNaN(page)) page=1;
        //超过总页数
        if (page>${p.totalPage}) page=${p.totalPage}
        //如果当前页和输入的页数不一致 才发生请求
        if(page!=${p.currentIndex}) location.href="/usermvc/show?currentIndex="+page;
    }
    let change = (o)=>{
        location.href = "/usermvc/show?pageSize="+o.value;
    }
</script>
</html>
