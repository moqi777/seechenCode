<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>短消息平台</title>
<link type="text/css" rel="stylesheet" href="css/sms.css" />
<script src="/js/register.js"></script>
</head>
<body>
<div id="regTitle" class="png"></div>
<div id="regForm" class="userForm png">

	<form action="/emailUser/register" onsubmit = "return check()" method="post" enctype="multipart/form-data">
		<dl>
		    <div id="error" style="color: red"> </div>
			<dd>
				<br>
				&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<img onclick="upload()" src="https://s2.loli.net/2024/08/02/MgH2iNkdstCPQKB.webp"
					 style="width: 70px;height: 70px;border-radius: 50px;cursor: pointer;" title="点击上传头像" id="img">
				<input name="upImg" type="file" style="display: none;" id="upImg" onchange="updateImg(this)">
			</dd>
			<dt>用 户 名：</dt>
			<dd><input type="text" name="username" /></dd>
			<dt>密　　码：</dt>
			<dd><input type="password" name="password" /></dd>
			<dt>确认密码：</dt>
			<dd><input type="password" name="affirm" /></dd>
			<dt>邮　　箱：</dt>
			<dd><input type="text" name="email" /></dd>
		</dl>
		<div class="buttons">
			<input class="btn-reg png" type="submit" name="register" value=" " />
			<input class="btn-reset png" type="reset" name="reset" value=" " />
		</div>
		<div class="goback"><a href="index.jsp" class="png">返回登录页</a></div>
	</form>
</div>
</body>
</html>
