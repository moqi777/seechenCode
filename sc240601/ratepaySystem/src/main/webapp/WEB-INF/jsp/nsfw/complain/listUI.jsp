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
                       	投诉标题：<input/>
                    </li>
                    <li>
                       	投诉时间：<input onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm:ss'})"/>
                              - 
                             <input onfocus="WdatePicker({skin:'whyGreen',dateFmt: 'yyyy-MM-dd HH:mm:ss'})"/>
                    </li>
                    <li>
                       	状态：<select><option>请选择状态</option></select>
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
                        <tr class="t_tit">
                            <td align="center">投诉不作为</td>
                            <td width="120" align="center">技术部</td>
                            <td width="120" align="center">张三</td>
                            <td width="140" align="center">2015-02-07 12:12:12</td>
                            <td width="100" align="center">未处理</td>
                            <td width="100" align="center"><a href="${basePath}jsp/nsfw/complain/dealUI.jsp">受理</a></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </div>
</form>

</body>
</html>