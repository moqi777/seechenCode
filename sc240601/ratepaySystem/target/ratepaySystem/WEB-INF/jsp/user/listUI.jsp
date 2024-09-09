<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%
    pageContext.setAttribute("basePath", request.getContextPath()+"/") ;
%>
<html>
<head>
    <title>用户管理</title>
    <script type="text/javascript" src="/js/jquery/jquery-1.10.2.min.js"></script>
    <link href="/css/skin1.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript">
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>用户管理</strong></div> </div>
                <div class="search_art">
                    <li>
                        用户名：<input/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" onclick="doSearch()"/></li>
                    <li style="float:right;">
                        <input type="button" value="新增" class="s_button" onclick="javascript:location.href='addUI.jsp'"/>&nbsp;
                        <input type="button" value="删除" class="s_button" onclick="doDeleteAll()"/>&nbsp;
                    </li>
                </div>
                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td width="30" align="center"><input type="checkbox" onclick="doSelectAll()" /></td>
                            <td width="140" align="center">用户名</td>
                            <td width="140" align="center">帐号</td>
                            <td width="160" align="center">所属部门</td>
                            <td width="80" align="center">性别</td>
                            <td align="center">电子邮箱</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                        <c:forEach var="uuser" items="${page.list}">
                            <tr >
                                <td width="30" align="center"><input type="checkbox" id="selAll"/></td>
                                <td width="140" align="center">${uuser.name}</td>
                                <td width="140" align="center">${uuser.account}</td>
                                <td width="160" align="center">${uuser.dept}</td>
                                <td width="80" align="center"><c:if test="${uuser.gender==true}">男</c:if><c:if test="${uuser.gender==false}">女</c:if></td>
                                <td align="center">${uuser.email}</td>
                                <td width="100" align="center"><a href="editUI.jsp">修改</a> <a href="#">删除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <li style="float:right;margin: 15px">
                <input type="button" value="首页" class="s_button" onclick="first()"/>&nbsp;
                <input type="button" value="上一页" class="s_button" onclick="last()"/>&nbsp;

                <c:forEach begin="1" end="${page.totalPage}" var="i">
                    <span style="cursor: pointer;
                    <c:if test="${page.currentIndex==i}">background-color: #add8ee;</c:if>
                                width: 100px;height: 20px;border: 1px solid black;
                            border-radius: 100%;font-weight: bolder;"
                          <c:if test="${page.currentIndex!=i}">onclick="location.href='/uuser/toListUI?currentIndex='+'${i}'" </c:if>>
                        &nbsp;&nbsp;${i}&nbsp;&nbsp;
                    </span>
                </c:forEach>

                <input type="button" value="下一页" class="s_button" onclick="next()"/>&nbsp;
                <input type="button" value="尾页" class="s_button" onclick="end()"/>&nbsp;

                显示页数：<select onchange="location.href='/uuser/toListUI?currentIndex=1&pageSize='+this.value">
                            <option <c:if test="${pageSize==5}">selected</c:if> value="5">5页</option>
                            <option <c:if test="${pageSize==10}">selected</c:if> value="10">10页</option>
                            <option <c:if test="${pageSize==20}">selected</c:if> value="20">20页</option>
                        </select>
            </li>
        </div>
    </div>
</form>
<script>
    let first = ()=>{
        if ("${page.currentIndex}"!=1){
            location.href="/uuser/toListUI?currentIndex=1";
        }
    }
    let end = ()=>{
        if ("${page.currentIndex}"!="${page.totalPage}"){
            location.href="/uuser/toListUI?currentIndex="+"${page.totalPage}";
        }
    }
    let next = ()=>{
        if ("${page.currentIndex}"!="${page.totalPage}"){
            location.href="/uuser/toListUI?currentIndex="+"${page.currentIndex+1}";
        }
    }
    let last = ()=>{
        if ("${page.currentIndex}"!=1){
            location.href="/uuser/toListUI?currentIndex="+"${page.currentIndex-1}";
        }
    }
</script>
</body>
</html>