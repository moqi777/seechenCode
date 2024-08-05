<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%
	pageContext
			.setAttribute("basePath", request.getContextPath() + "/");
%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>我要投诉</title>
<script type="text/javascript" charset="utf-8"
	src="${basePath}js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${basePath}js/ueditor/ueditor.all.min.js"> </script>
<script type="text/javascript" charset="utf-8"
	src="${basePath}js/ueditor/lang/zh-cn/zh-cn.js"></script>

<script type="text/javascript">
   var ue = UE.getEditor('editor');
   </script>

<script type="text/javascript">
   
  
   </script>
</head>
<body>
	<form id="form" name="form" action="" method="post"
		enctype="multipart/form-data">
		<div class="vp_d_1">
			<div style="width: 1%; float: left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
			<div class="vp_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>工作主页</strong>&nbsp;-&nbsp;我要投诉
						</div>
					</div>
					<div class="tableH2">我要投诉</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="250px">投诉标题：</td>
							<td><s:textfield name="complain.compTitle" /></td>
						</tr>
						<tr>
							<td class="tdBg">被投诉人部门：</td>
							<td><s:select id="toCompDept" name="complain.toCompDept"
									list="#{'请选择部门':'请选择部门','部门A':'部门A','部门B':'部门B' }" /></td>
						</tr>
						<tr>
							<td class="tdBg">被投诉人姓名：</td>
							<td><select id="toCompName" name="complain.toCompName"></select>
							</td>
						</tr>
						<tr>
							<td class="tdBg">投诉内容：</td>
							<td><s:textarea id="editor" name="complain.compContent"
									cssStyle="width:90%;height:160px;" /></td>
						</tr>
						<tr>
							<td class="tdBg">是否匿名投诉：</td>
							<td><s:radio name="complain.isNm"
									list="#{'0':'非匿名投诉','1':'匿名投诉' }" value="0" /></td>
						</tr>

					</table>
					<!--暂存投诉用户的信息  -->
					<input type="hidden" value="${loginUser.name}"
						name="complain.compName"> <input type="hidden"
						value="${loginUser.dept}" name="complain.compCompany"> <input
						type="hidden" value="${loginUser.mobile}"
						name="complain.compMobile">
					<div class="tc mt20">
						<input type="button" class="btnB2" value="保存" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							onclick="javascript:window.close()" class="btnB2" value="关闭" />
					</div>
				</div>
			</div>
			<div style="width: 1%; float: left;">&nbsp;&nbsp;&nbsp;&nbsp;</div>
		</div>
	</form>
</body>
</html>