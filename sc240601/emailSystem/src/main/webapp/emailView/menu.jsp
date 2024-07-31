<%@ page language="java" import="java.util.*" isELIgnored="false" pageEncoding="UTF-8"%>
<script src="/js/isExit.js"></script>
<div class="menu">
				<span>当前用户：<a href="/email?type=selectEmail&fromOrTo=0&index=1">${sessionScope.get("loginUser").username}</a>
				</span> <span><a href="/emailView/newMsg.jsp">发送邮件</a></span>
				<span><a href="/email?type=selectEmail&fromOrTo=1&index=1">已发邮件</a></span>
				<span><a href="javascript:void(0)" onclick="isExit()">退出</a></span>
			</div>