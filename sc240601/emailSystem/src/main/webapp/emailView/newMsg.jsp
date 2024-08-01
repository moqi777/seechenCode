<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 <title>发邮件</title>	    
<link type="text/css" rel="stylesheet" href="/css/sms.css" />
<script src="/js/newMsg.js"></script>
</head>

 <body>
 <form action="/email?type=sendEmail" method="post" onsubmit="return check()">
	<div id="main">
		<div class="mainbox">			
			<%@include file="menu.jsp" %>
			<h1>发送邮件</h1>
			<div class="content">
				<div class="message">
						<div class="tmenu">
							<ul class="clearfix">
								<%--根据是否传入了发件人来判断显示哪个输入框--%>
								<c:if test="${empty param.fromname}">
									<li>
										发送给：
										<input type="text" name="toUser" placeholder="请输入用户名或邮箱">
									</li>
									<li>标题：<input type="text" name="title" id="title"/></li>
								</c:if>
								<c:if test="${not empty param.fromname}">
									<li>
										回信给：
										<input type="text" name="toUser" value="${param.fromname}" readonly>
									</li>
									<li>标题：<input type="text" name="title" value="回复邮件" readonly/></li>
								</c:if>
								<li><div id="error" style="color: red"></div></li>
							</ul>
						</div>
						<div class="view">
							<textarea name="content" id="content"></textarea>
							<div class="send"><input type="submit" name="submit" value=" " /></div>
						</div>
					
				</div>
			</div>
		</div>
	</div>
</form>
</body>
</html>
