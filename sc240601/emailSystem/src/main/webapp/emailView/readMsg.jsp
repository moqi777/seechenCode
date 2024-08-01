<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件平台</title>
<link type="text/css" rel="stylesheet" href="/css/sms.css" />
</head>
	<body>
		<div id="main">
			<div class="mainbox">
				<div class="title readMessage png"></div>
				<%@include file="menu.jsp" %>
				<h1>阅读邮件</h1>
				<div class="content">
					<div class="message">
							<div class="tmenu">
								<ul class="clearfix">
									<li>题目：${email.title} </li>
									<br>
									<li>发送方：${email.fromname}</li>
									<br>
									<li>接收方：${email.toname}</li>
									<br>
									<li>时间：${email.createdate}</li>
								</ul>
							</div>
					  	 	<div class="view">
								<p>${email.content}</p>
							</div>
					</div>
				</div>
			</div>
		</div>
	</body>
</html>
