<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉受理管理</title>
</head>
<body class="rightBody">
<form id="form" name="form" action="${basePath }nsfw/complain_deal.action?complain.compId=${complain.compId}" method="post" enctype="multipart/form-data">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
    <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong>&nbsp;-&nbsp;投诉受理</div></div>
    <div class="tableH2">投诉详细信息<span style="color:red;">(<s:property value="#complainStateMap[complain.state]"/>)</span></div>
    <table id="baseInfo" width="100%" align="center" class="list" border="0" cellpadding="0" cellspacing="0"  >
    	<tr><td colspan="2" align="center">投诉人信息</td></tr>
        <tr>
            <td class="tdBg" width="250px">是否匿名投诉：</td>
            <td><s:property value="complain.isNm?'匿名投诉':'非匿名投诉'"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉人单位：</td>
            <td>
            <s:if test="!complain.isNm">
            <s:property value="complain.compCompany"/>
            </s:if>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人姓名：</td>
            <td>
            <s:if test="!complain.isNm">
            <s:property value="complain.compName"/>
            </s:if>
            </td>
        </tr>
        <tr>
            <td class="tdBg">投诉人手机：</td>
            <td>
            <s:if test="!complain.isNm">
            <s:property value="complain.compMobile"/>
            </s:if>
            <s:else>
            	<!-- 处理手机号码，字符串操作 -->
            	${fn:substring(complain.compMobile,0,3) }****${fn:substring(complain.compMobile,7,11) }
            </s:else>
            </td>
        </tr>
        <tr><td colspan="2" align="center">投诉信息</td></tr>
        <tr>
            <td class="tdBg">投诉时间：</td>
            <td>
            <!--格式化投诉时间
           	<s:date name="complain."/>  -->
           	<fmt:formatDate value="${complain.compTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">被投诉部门：</td>
            <td><s:property value="complain.toCompDept"/></td>
        </tr>
        <tr>
            <td class="tdBg">被投诉人：</td>
            <td><s:property value="complain.toCompName"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉标题：</td>
            <td><s:property value="complain.compTitle"/></td>
        </tr>
        <tr>
            <td class="tdBg">投诉内容：</td>
            <td><s:property value="complain.compContent" escape="false"/></td>
        </tr>
        <tr><td colspan="2" align="center">受理信息</td></tr>
        <tr>
            <td colspan="2">
            	    <c:forEach items="${complain.complainReplies}" var="complainReplies" varStatus="vs">
            	    
            		<fieldset style="border: solid 1px #c0c0c0;margin-top:5px;"><legend style="color:green;font-weight:bold;">回复${vs.count}&nbsp;</legend>
						<div style="width:100%; text-align:center;color:#ccc;maring-top:5px;">
						回复部门：${complainReplies.replyDept }&nbsp;&nbsp;
						回复人：${complainReplies.replyer }&nbsp;&nbsp;
						回复时间：<fmt:formatDate value="${complainReplies.replyTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
						</div>
						<div style="width:100%;maring-top:10px;font-size:13px;padding-left:5px;">${complainReplies.replyContent }</div>
					</fieldset>
            	   </c:forEach>
            </td>
        </tr>
        <tr><td colspan="2" align="center">受理操作</td></tr>
        <tr>
            <td class="tdBg">回复部门：</td>
            <td>
            ${sessionScope.loginUser.dept }
            <input type="hidden" name="complainReply.replyDept" value="${sessionScope.loginUser.dept }"/>
            </td>
        </tr>
        <tr>
            <td class="tdBg">回复人：</td>
            <td>
            ${loginUser.name }
            <input type="hidden" name="complainReply.replyer" value="${loginUser.name }"/>
            </td>
        </tr>

        <tr>
            <td class="tdBg" width="200px">回复内容：</td>
            <td><s:textarea name="complainReply.replyContent" cols="90" rows="8" /></td>
        </tr>
    </table>
    <!-- 页面隐藏域
             -->
            <input type="hidden" name="complain.compTitle" value=${complain.compTitle }>
            <input type="hidden" name="complain.state" value=${complain.state }>
            <input type="hidden" name="startTime" value=${startTime }>
            <input type="hidden" name="endTime" value=${endTime }>
    <div class="tc mt20">
        <input type="submit" class="btnB2" value="保存" />
        &nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button"  onclick="javascript:history.go(-1)" class="btnB2" value="返回" />
    </div>
    </div></div></div>
</form>
</body>
</html>