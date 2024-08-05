<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/header.jsp"%>
    <title>投诉受理管理</title>
    <!--引入日期组件  -->
    <script type="text/javascript" src="${basePath}js/datepicker/WdatePicker.js"></script>
    <script type="text/javascript">
    
    </script>
</head>
<body class="rightBody">
<form name="form1" action="" method="post">
    <div class="p_d_1">
        <div class="p_d_1_1">
            <div class="content_info">
                <div class="c_crumbs"><div><b></b><strong>投诉受理管理</strong></div> </div>
                <div class="search_art">
                    <li>
                       	投诉标题：<s:textfield name="complain.compTitle" cssClass="s_text"  cssStyle="width:160px;"/>
                    </li>
                    <li>
                       	投诉时间：<s:textfield id="startTime" name="startTime" cssClass="s_text"  cssStyle="width:160px;" onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm:ss'})"/>
                              - 
                             <s:textfield id="endTime" name="endTime" cssClass="s_text"  cssStyle="width:160px;" onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm:ss'})"/>
                    </li>
                    <li>
                       	状态：<s:select name="complain.state" list="#{ }" headerKey="" headerValue="请选择投诉状态"/>
                    </li>
                    <li><input type="button" class="s_button" value="搜 索" /></li>
                    <li style="float:right;">
                    	<input type="button" value="统计" class="s_button" />&nbsp;
                    </li>

                </div>

                <div class="t_list" style="margin:0px; border:0px none;">
                    <table width="100%" border="0">
                        <tr class="t_tit">
                            <td align="center">投诉标题</td>
                            <td width="120" align="center">被投诉部门</td>
                            <td width="120" align="center">被投诉人</td>
                            <td width="140" align="center">投诉时间</td>
                            <td width="100" align="center">受理状态</td>
                            <td width="100" align="center">操作</td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>