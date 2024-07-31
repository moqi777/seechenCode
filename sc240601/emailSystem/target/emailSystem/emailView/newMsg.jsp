<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
								<li>
									发送给：
									<%--
									<select name="toUser">
						  	 					<option>李四</option>
						  	 					<option>王五</option>
						  	 					<option>赵六</option>
						  	 					<option>天气</option>
						  	 		</select>
						  	 		--%>
									<input type="text" name="toUser" placeholder="请输入用户名或邮箱">
								</li>								
								<li>标题：<input type="text" name="title" id="title"/></li>
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
