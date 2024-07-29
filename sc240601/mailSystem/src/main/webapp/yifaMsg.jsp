<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件收发平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@include file="menu.jsp" %>
			<div id="error">${error}</div>
			<h1>已发邮件</h1>
			<div class="content messageList">
				<div class="emaildo">全选 <input type="checkbox">  <button>删除勾选</button></div>
				<ul>
					<li> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p>  <em>2016-05-05 12:12:12</em></li>
				<li> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p>  <em>2016-05-05 12:12:12</em></li>
				<li> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p>  <em>2016-05-05 12:12:12</em></li>
				<li> <input type="checkbox"/> <b>标题</b>
						<p>邮件内容（如果超过显示长度，超出部分用省略号代替）</p>  <em>2016-05-05 12:12:12</em></li>
				
				</ul>

			</div>
		</div>
	</div>
</body>
</html>
