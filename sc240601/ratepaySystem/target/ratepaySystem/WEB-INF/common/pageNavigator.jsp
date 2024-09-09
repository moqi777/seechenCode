<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="c_pate" style="margin-top: 5px;">
		<table width="100%" class="pageDown" border="0" cellspacing="0"
			cellpadding="0">
			<tr>
				<td align="right">
                 	总共${pageResult.totalRecord }条记录，当前第 ${pageResult.pageNum } 页，共 ${pageResult.totalPage } 页 &nbsp;&nbsp;
                            <c:if test="${pageResult.pageNum >1}">
                            <a href="javascript:doGoPage(<s:property value="%{pageResult.pageNum -1}"/>)">上一页</a>
                            &nbsp;&nbsp;</c:if>
                            <c:if test="${pageResult.pageNum <pageResult.totalPage}">
                            <a href="javascript:doGoPage(<s:property value="%{pageResult.pageNum +1}"/>)">下一页</a>
                            </c:if>
					到&nbsp;<input type="text" name="pageNum" style="width: 30px;" onkeypress="if(event.keyCode == 13){doGoPage(this.value);}" min="1"
					max="" value="${pageResult.pageNum }" /> &nbsp;&nbsp;
			    </td>
			</tr>
			
		</table>
		
</div>
<script type="text/javascript">    
    //翻页
     function doGoPage(pageNum){
        	//给inputd pageNum赋值
        	$("input[name='pageNum']").attr("value",pageNum);
        	var form=document.forms[0];
        	form.action=list_url;
        	form.submit();
        }
</script>
