<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<!--测试提交简单的数据-->
<form action="/in" method="post">
    姓名：<input type="text" name="name"><br/>
    年龄：<input type="text" name="age"><br/>
    分数：<input type="text" name="score"><br/>
    <button>提交</button>
</form>
<a href="/in?name=张三&age=18&score=95.5">链接</a>

<%--2.测试提交多个数据--%>
<form action="/inMany" method="post">
    批量删除:
    <input type="checkbox" value="1" name="ids">1
    <input type="checkbox" value="2" name="ids">2
    <input type="checkbox" value="3" name="ids">3
    <input type="checkbox" value="4" name="ids">4<br>
    爱好：
    <input type="checkbox" value="篮球" name="like">篮球
    <input type="checkbox" value="足球" name="like">足球
    <input type="checkbox" value="乒乓球" name="like">乒乓球
    <input type="checkbox" value="羽毛球" name="like">羽毛球 <br>
    <button>提交</button>
</form>

<%--3.测试提交多种数据  新增或者注册--%>
<form action="/inAdd" method="post">
    姓名：<input type="text" name="name"><br/>
    存款：<input type="text" name="money"><br/>
    <%--400是客户端参数异常：原因是String转换成日期需要格式 --%>
    生日：<input type="date" name="time"><br/>
    <%--...  --%>
    <button>提交</button>
</form>

<a href="/testOut">测试输出</a><br>
<a href="/testOut2">测试输出2</a><br>
<a href="/testOut3">测试输出3</a><br>
</body>
</html>
