<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<script src="/js/isExit.js"></script>
<div class="menu" style="position: relative;">
	<img src="/upload/${sessionScope.get("loginUser").img}" title="头像"
		 style="width: 70px;height: 70px;border-radius: 50px;position: absolute;right: 0px;top: -80px">

				<span>当前用户：<a href="/email/selectEmail?fromOrTo=0&index=1">${sessionScope.get("loginUser").username}</a>
				</span> <span><a href="/emailView/newMsg.jsp">发送邮件</a></span>
				<span><a href="/email/selectEmail?fromOrTo=1&index=1">已发邮件</a></span>
				<span><a href="javascript:void(0)" onclick="isExit()">退出</a></span>
			</div>