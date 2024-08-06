<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<%@include file="/common/header.jsp"%>
<title>投诉受理管理</title>
</head>
<body class="rightBody">
	<form id="form" name="form" action="" method="post"
		enctype="multipart/form-data">
		<div class="p_d_1">
			<div class="p_d_1_1">
				<div class="content_info">
					<div class="c_crumbs">
						<div>
							<b></b><strong>投诉受理管理</strong>&nbsp;-&nbsp;投诉受理
						</div>
					</div>
					<div class="tableH2">
						投诉详细信息<span style="color:red;">(未处理)</span>
					</div>
					<table id="baseInfo" width="100%" align="center" class="list"
						border="0" cellpadding="0" cellspacing="0">
						<tr>
							<td colspan="2" align="center">投诉人信息</td>
						</tr>
						<tr>
							<td class="tdBg" width="250px">是否匿名投诉：</td>
							<td>是</td>
						</tr>
						<tr>
							<td class="tdBg">投诉人单位：</td>
							<td>asdsa</td>
						</tr>
						<tr>
							<td class="tdBg">投诉人姓名：</td>
							<td>匿名</td>
						</tr>
						<tr>
							<td class="tdBg">投诉人手机：</td>
							<td>123456</td>
						</tr>
						<tr>
							<td colspan="2" align="center">投诉信息</td>
						</tr>
						<tr>
							<td class="tdBg">投诉时间：</td>
							<td>2015-05-05 12:12:12</td>
						</tr>
						<tr>
							<td class="tdBg">被投诉部门：</td>
							<td>技术部</td>
						</tr>
						<tr>
							<td class="tdBg">被投诉人：</td>
							<td>张三</td>
						</tr>
						<tr>
							<td class="tdBg">投诉标题：</td>
							<td>sdfsdfsd</td>
						</tr>
						<tr>
							<td class="tdBg">投诉内容：</td>
							<td>速度发水电费撒地方撒的发生地方撒旦发生地方撒旦法撒旦</td>
						</tr>
						<tr>
							<td colspan="2" align="center">受理信息</td>
						</tr>
						<tr>
							<td colspan="2">
								<fieldset style="border: solid 1px #c0c0c0;margin-top:5px;">
									<legend style="color:green;font-weight:bold;">回复${vs.count}&nbsp;</legend>
									<div
										style="width:100%; text-align:center;color:#ccc;maring-top:5px;">
										回复部门：行政部&nbsp;&nbsp; 回复人：李四&nbsp;&nbsp; 回复时间：2015-05-06
										15:23:22</div>
									<div
										style="width:100%;maring-top:10px;font-size:13px;padding-left:5px;">证据确凿</div>
								</fieldset>
								<fieldset style="border: solid 1px #c0c0c0;margin-top:5px;">
									<legend style="color:green;font-weight:bold;">回复${vs.count}&nbsp;</legend>
									<div
										style="width:100%; text-align:center;color:#ccc;maring-top:5px;">
										回复部门：财务部&nbsp;&nbsp; 回复人：王五&nbsp;&nbsp; 回复时间：2015-05-06
										15:23:23</div>
									<div
										style="width:100%;maring-top:10px;font-size:13px;padding-left:5px;">有意义</div>
								</fieldset>
							</td>
						</tr>
						<tr>
							<td colspan="2" align="center">受理操作</td>
						</tr>
						<tr>
							<td class="tdBg">回复部门：</td>
							<td>行政部</td>
						</tr>
						<tr>
							<td class="tdBg">回复人：</td>
							<td>当前登录人</td>
						</tr>
						<tr>
							<td class="tdBg" width="200px">回复内容：</td>
							<td><textarea cols="90" rows="8" ></textarea></td>
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