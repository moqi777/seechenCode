﻿﻿<%@ page contentType="text/html; charset=UTF-8"%>
<%
    pageContext.setAttribute("ctx", request.getContextPath()) ;
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>税务局税收服务平台</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="/css/home.css" rel="stylesheet" type="text/css" />
</head>
<body>
<!-- 头部{ -->
<table width="100%" border="0" align="center" cellpadding="0"
       cellspacing="0" background="/images/home/top_bg.png" class="top">
    <tr>
        <td width="32" height="106">&nbsp;</td>
        <td width="418" height="106" align="left" valign="middle">
            <img class="zxx_test_png" src="/images/home/ind01.png" width="470" height="90" alt="" />
        </td>
        <td width="211">&nbsp;</td>
        
        <td width="331" align="right" valign="top">
            <table width="350" border="0" cellpadding="0" cellspacing="0">
                <tr>
                    <td width="64" height="4"></td>
                    <td width="25" height="5"></td>
                    <td width="120" height="4"></td>
                    <td width="25" height="4"></td>
                    <td width="40" height="4"></td>
                    <td width="25" height="4"></td>
                    <td width="50" height="4"></td>
                </tr>
                <tr>
                    <td align="center"></td>
                    <td align="left"></td>
                    <td align="right">
                        <a><b></b><font color="blue">欢迎您，${user.name }&nbsp;</font></a>
                    </td>
                    <td align="center"><img src="/images/home/help.png" width="12" height="17"  /></td>
                    <td align="left"><a href="javascript:void(0);">帮助</a></td>
                    <td align="center"><img src="/images/home/exit.png" width="14" height="14"   /></td>
                    <td align="left" valign="middle" ><a href="/jsp/login/loginUI.jsp">退出</a></td>
                </tr>
            </table>
        </td>
    </tr>
</table>
<!-- }头部 -->
<!-- 导航{ -->
<div class="menu">
    <ul class="clearfix">
        <li class="hover"><a href="/jsp/sys/sys.jsp">工作主页</a></li>
        <li><a href="javascript:void(0);">行政管理</a></li>
        <li><a href="javascript:void(0);">后勤服务</a></li>
        <li><a href="javascript:void(0);">在线学习</a></li>       
        <li><a href="/jsp/nsfw/frame.jsp">纳税服务</a> </li>
        <li><a href="javascript:void(0);">我的空间</a></li>
    </ul>
</div>
<!-- }导航 -->
<!-- 左{ -->
<div class="content">
    <div class="left">
        <!-- 个人资料{ -->
        <div class="left_grzx1">
            <div class="left_grzxbt">
                <h1>个人资料</h1>
            </div>
            <table width="98%" border="0" align="center">
                <tr>
                    <td width="76" height="100" align="center" valign="middle">
                        <div class="left-tx">
                            
							<img src="/images/home/gs09.png" width="70" height="70" />
                        </div>
                    </td>
                    <td width="5%"><img src="/images/home/gs10.png" width="4" height="59" alt="" /></td>
                    <td width="60%"><table width="95%" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                            <td colspan="2" style=" font-weight:bold; color:#3a7daa;">xx名</td>
                        </tr>
                        <tr>
                            <td colspan="2">所属部门：xx部门</td>
                        </tr>
                    </table>
                    </td>
                </tr>
            </table>
        </div>
        <!-- }个人资料 -->
    </div>
<!-- }左 -->

    <!-- 右{ -->
    <div class="right">
        <div class="left_grzx1">
            <div class="left_grzxbt">
                <h1>信息列表</h1>
            </div>
            <table width="98%" border="0" align="center">
            	
                <tr>
                    <td height="23">
                    xx标题
                    </td>
                    <td width="150px">xx分类</td>
                    <td width="150px">xx创建人</td>
                    <td width="150px">xx创建时间</td>
                </tr>
                
            </table>
        </div>
    </div>
    <!-- }右-->
    <div class="clear"></div>

    <div class="layout_center">
        <div class="lc_grzx1">
            <div class="lc_grzxbt">
                <h1>我的投诉</h1>
                <div style="float:right;padding-top:3px;">
                	<a href="/jsp/sys/complainAddUI.jsp" >我要投诉</a>&nbsp;&nbsp;
                </div>
            </div>
            <table width="98%" border="0" align="center">
                
                <tr>
                    <td height="23">
                    xxx标题
                    </td>
                    <td width="180px">xx受理状态</td>
                    <td width="180px">是否匿名投诉</td>
                    <td width="180px">投诉时间</td>
                </tr>
                
            </table>
        </div>

        <div class="lc_grzx1">
            <div class="lc_grzxbt">
                <h1>我的咨询</h1>
            </div>
            <table width="98%" border="0" align="center">
                <tr>
                    <td></td>
                    <td width="150px"></td>
                    <td width="150px"></td>
                </tr>
            </table>
        </div>
    </div>
</div>
<!-- 尾部{ -->
<div class="foot">版权所有©税务局 2015</div>
<!-- }尾部 -->
</body>
</html>