<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>我要投诉</title>
<script type="text/javascript" charset="utf-8"
	src="${basePath}js/ueditor/ueditor.config.js"></script>
<script type="text/javascript" charset="utf-8"
	src="${basePath}js/ueditor/ueditor.all.min.js">
</script>
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
							<td class="tdBg" width="200">投诉标题：</td>
							<td><input /></td>
						</tr>
						<tr>
							<td class="tdBg">被投诉人部门：</td>
							<td><select>
									<option>请选择部门</option>
							</select></td>
						</tr>
						<tr>
							<td class="tdBg">被投诉人姓名：</td>
							<td><select>
									<option>指定部门下的员工</option>
							</select></td>
						</tr>
						<tr>
							<td class="tdBg">投诉内容：</td>
							<td><textarea id="editor" style="width: 90%;"></textarea></td>
						</tr>
						<tr>
							<td class="tdBg">是否匿名投诉：</td>
							<td><input type="radio">是 <input type="radio">否</td>
						</tr>

					</table>
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