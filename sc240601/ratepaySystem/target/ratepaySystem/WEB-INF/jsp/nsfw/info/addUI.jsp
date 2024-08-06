<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>信息发布管理</title>
    <script type="text/javascript" charset="utf-8" src="${basePath}js/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="${basePath}js/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="${basePath}js/ueditor/lang/zh-cn/zh-cn.js"></script>
   <script type="text/javascript">
   var ue = UE.getEditor('editor');
   </script>
</head>
<body class="rightBody">
<form id="form" name="form" action="listUI.jsp" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>信息发布管理</strong>&nbsp;-&nbsp;新增信息</div></div>
    <div class="tableH2">新增信息</div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
        <tr>
            <td class="tdBg" width="200px">信息分类：</td>
            <td><select><option>通知公告</option><option>纳税指导</option></select></td>
            <td class="tdBg" width="200px">来源：</td>
            <td><input/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息标题：</td>
            <td colspan="3"><input/></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">信息内容：</td>
            <td colspan="3"><textarea id="editor"  style="width:90%;height:160px;"></textarea></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">备注：</td>
            <td colspan="3"><textarea cols="90" rows="3"></textarea></td>
        </tr>
        <tr>
            <td class="tdBg" width="200px">创建人：</td>
            <td>
            当前登陆人
            </td>
            <td class="tdBg" width="200px">创建时间：</td>
            <td>
            当前时间
            </td>
        </tr>
    </table>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>