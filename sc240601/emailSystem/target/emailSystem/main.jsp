<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="utf-8"%>
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
			<div><span style="font-size:24px; font-weight: bold;">查看邮件</span> <input class="searchinp"  placeholder="可通过发送人、标题、内容搜索"/> <button>搜索</button></div>
			
			<div class="content messageList" style="clear: both;">
				<div class="emaildo">全选 <input type="checkbox"> <button>标记为已读</button>  <button>删除勾选</button></div>
				<ul>
					<c:if test="${empty emailList}">
						<li class="unReaded">没有邮箱</li>
					</c:if>

					<c:if test="${not empty emailList}">
						<c:forEach var="email" items="${emailList}">
							<li class="unReaded"> <input type="checkbox"/> <b>${email.title}</b>
								<p>${email.content}</p> <em><a href="">回信</a></em> <em><a
										href="">删除</a></em></li>
						</c:forEach>
					</c:if>
				</ul>
				<br>
<c:if test="${not empty page}">
	<p style="text-align:right;">
		<b>[${page.currentIndex}/${page.totalPages}]</b> &nbsp;

		<c:if test="${page.currentIndex != 1}">
			<a href="/email?type=selectEmail&index=${page.currentIndex - 1}">上一页</a> &nbsp;
		</c:if>
		<c:if test="${page.currentIndex == 1}">
			<a href="javascript:void(0)">上一页</a> &nbsp;
		</c:if>

		<c:if test="${page.currentIndex != page.totalPages}">
			<a href="/email?type=selectEmail&index=${page.currentIndex + 1}">下一页</a>
		</c:if>
		<c:if test="${page.currentIndex == page.totalPages}">
			<a href="javascript:void(0)">下一页</a>
		</c:if>
	</p>
</c:if>
			</div>
		</div>
	</div>
</body>
</html>
