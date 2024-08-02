<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="utf-8"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>邮件收发平台</title>
<link type="text/css" rel="stylesheet" href="/css/sms.css" />
<script src="/js/mainAndyifaMsg.js"></script>
</head>
<body>
	<div id="main">
		<div class="mainbox">
			<div class="title myMessage png"></div>
			<%@include file="menu.jsp" %>
			<div id="error">${error}</div>
			<h1>已发邮件</h1>
			<div class="content messageList">
				<div class="emaildo">全选 <input type="checkbox"  onchange="allCheckbox(this)">
					<button  onclick="deleteCheckbox()">删除勾选</button></div>
				<ul>
					<c:if test="${empty emailList}">
						<li class="unReaded">没有邮箱</li>
					</c:if>

					<c:if test="${not empty emailList}">
						<c:forEach var="email" items="${emailList}">

							<%--如果超出指定长度拼接...--%>
							<%--获取到标题长度，并用50减去 ，这样得出来的就是要截取邮件内容的长度--%>
							<c:set var="content_subLen" value="${30-fn:length(email.title)}"></c:set>
							<%-- 判断内容是否需要截取，并设置emailSub的值 --%>
							<c:choose>
								<c:when test="${fn:length(email.content) > content_subLen}">
									<c:set var="emailSub" value="${fn:substring(email.content, 0, content_subLen)} ..."></c:set>
								</c:when>
								<c:otherwise>
									<c:set var="emailSub" value="${email.content}"></c:set>
								</c:otherwise>
							</c:choose>

							<%--<li class="unReaded">  把class="unReaded"删了就是已读--%>
							<!--通过三目运算判断是否已读选择是否添加unReaded属性-->
							<%--这里的已读是接收方的已读--%>
							<li class="${email.state==1?'unReaded':''}">
								<input type="checkbox" class="checkbox"/>
								<%--设置一个隐藏的属性用于标记该行邮件的id--%>
								<input value="${email.id}" type="hidden">
								<b onclick="readEmail(this)" class="email_tille">${email.title}</b>&nbsp;&nbsp;&nbsp;
								<p>${emailSub}</p>
								<em><fmt:formatDate value="${email.createdate}" pattern="yyyy-MM-dd HH:mm"/></em>
							</li>
						</c:forEach>
					</c:if>
				</ul>
				<br>
<c:if test="${not empty page}">
	<p style="text-align:right;">
		<b>[${page.currentIndex}/${page.totalPages}]</b> &nbsp;

		<c:if test="${page.currentIndex != 1}">
			<a href="/email?type=selectEmail&fromOrTo=1&index=${page.currentIndex - 1}">上一页</a> &nbsp;
		</c:if>
		<c:if test="${page.currentIndex == 1}">
			<a href="javascript:void(0)">上一页</a> &nbsp;
		</c:if>

		<c:if test="${page.currentIndex != page.totalPages}">
			<a href="/email?type=selectEmail&fromOrTo=1&index=${page.currentIndex + 1}">下一页</a>
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
