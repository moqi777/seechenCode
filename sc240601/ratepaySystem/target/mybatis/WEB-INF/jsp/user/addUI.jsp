<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/WEB-INF/common/header.jsp"%>
<title>用户管理</title>
<!--引入日期组件  -->
<script type="text/javascript"
	src="/js/datepicker/WdatePicker.js"></script>
</head>
<body class="rightBody">
	<form id="form" name="form" action="listUI.jsp" method="post"
		enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>用户管理</strong>&nbsp;-&nbsp;新增用户
						</div>
					</div>
					<div class="tableH2">新增用户</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td class="tdBg" width="200px">所属部门：</td>
							<td><select><option>请选择 部门</option></select></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">头像：</td>
							<td><input type="file" name="headImg" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">用户名：</td>
							<td><input /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">帐号：</td>
							<td><input /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">密码：</td>
							<td><input /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">性别：</td>
							<td><input type="radio" />男 <input type="radio" />女</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">电子邮箱：</td>
							<td><input /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">手机号：</td>
							<td><input /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">生日：</td>
							<td><input
								onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm:ss'})" /></td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">状态：</td>
							<td><input type="radio" />有效 <input type="radio" />无效</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">备注：</td>
							<td><textarea cols="75" rows="3"></textarea></td>
						</tr>
					</table>
					<div class="tc mt20">
						<input type="submit" class="btnB2" value="保存" />
						&nbsp;&nbsp;&nbsp;&nbsp; <input type="button"
							onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>