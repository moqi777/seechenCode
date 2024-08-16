<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html; charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>文档列表 - 光年(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="../favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/materialdesignicons.min.css" rel="stylesheet">
<link href="../css/style.min.css" rel="stylesheet">
</head>
  
<body>
<div class="container-fluid">

  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-toolbar clearfix">
          <form class="pull-right search-bar" method="get" action="#!" role="form">
            <div class="input-group">
              <div class="input-group-btn">
                <input type="hidden" name="search_field" id="search-field" value="title">
                <button class="btn btn-default dropdown-toggle" id="search-btn" data-toggle="dropdown" type="button" aria-haspopup="true" aria-expanded="false">
                  栏目 <span class="caret"></span>
                </button>
                <ul class="dropdown-menu">
                  <li> <a tabindex="-1" href="javascript:void(0)" data-field="cat_name">栏目</a> </li>
                </ul>
              </div>
              <input type="text" class="form-control" value="" name="keyword" placeholder="请输入名称">
            </div>
          </form>
          <div class="toolbar-btn-action">
            <a class="btn btn-primary m-r-5" href="add.html"><i class="mdi mdi-plus"></i> 新增</a>
            <a class="btn btn-success m-r-5" href="#!"><i class="mdi mdi-check"></i> 启用</a>
            <a class="btn btn-warning m-r-5" href="#!"><i class="mdi mdi-block-helper"></i> 禁用</a>
            <a class="btn btn-danger" href="#!"><i class="mdi mdi-window-close"></i> 删除</a>
          </div>
        </div>
        <div class="card-body">

          <div class="table-responsive">
            <table class="table table-bordered">
              <thead>
              <tr>
                <th>
                  <label class="lyear-checkbox checkbox-primary">
                    <input type="checkbox" id="check-all"><span></span>
                  </label>
                </th>
                <th>编号</th>
                <th>用户名</th>
                <th>姓名</th>
                <th>头像</th>
                <th>手机</th>
                <th>邮箱</th>
                <th>性别</th>
                <th>角色</th>
                <th>状态</th>
                <th>操作</th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="a" items="${p.list}">
                <tr>
                  <td>
                    <label class="lyear-checkbox checkbox-primary">
                      <input type="checkbox" name="ids[]" value="1"><span></span>
                    </label>
                  </td>
                  <td>${a.id}</td>
                  <td>${a.account}</td>
                  <td>${a.name}</td>
                  <td><img src="" alt=""></td>
                  <td>${a.phone}</td>
                  <td>${a.email}</td>
                  <td>${a.sex==1?"男":"女"}</td>
                  <td>${a.roleid}</td>
                  <td>
                    <c:if test="${a.status == 1}">
                      <font class="text-success">正常</font>
                    </c:if>
                    <c:if test="${a.status == 0}">
                      <font class="text-warning">未验证</font>
                    </c:if>
                    <c:if test="${a.status == 2}">
                      <font class="text-danger">禁用</font>
                    </c:if>
                  </td>
                  <td>
                    <div class="btn-group">
                      <a class="btn btn-xs btn-default" href="#!" title="编辑" data-toggle="tooltip"><i class="mdi mdi-pencil"></i></a>
                      <a class="btn btn-xs btn-default" href="#!" title="删除" data-toggle="tooltip"><i class="mdi mdi-window-close"></i></a>
                    </div>
                  </td>
                </tr>
              </c:forEach>

              </tbody>
            </table>
          </div>
          <ul class="pagination">
            <%--上一页--%>
            <c:if test="${p.pageNum==1}"><li class="disabled"><span>«</span></li></c:if>
            <c:if test="${p.pageNum!=1}"><li><a href="/admin/show?currentIndex=${p.prePage}">«</a></li></c:if>
            <%--如果循环到了后面，给一个1可以直接到最前面--%>
            <c:if test="${p.navigatepageNums[0]!=1}"><li><a href="/admin/show?currentIndex=1">1</a></li><li class="disabled"><span>...</span></li></c:if>
            <%--循环页码展示--%>
            <c:forEach var="i" items="${p.navigatepageNums}">
              <%--如果是当前页给样式，但是不能跳转--%>
              <c:if test="${p.pageNum==i}">
                <li class="active"><span>${i}</span></li>
              </c:if>
              <%--如果不是当前页可以跳转，但是没有样式--%>
              <c:if test="${p.pageNum!=i}">
                <li><a href="/admin/show?currentIndex=${i}">${i}</a></li>
              </c:if>
            </c:forEach>
            <%--如果总页数很多，给一个尾页可以直接到最后一页--%>
            <c:if test="${p.navigatepageNums[7]!=p.pages}"><li class="disabled"><span>...</span></li><li><a href="/admin/show?currentIndex=${p.pages}">${p.pages}</a></li></c:if>
            <%--下一页--%>
            <c:if test="${p.pageNum==p.lastPage}"><li class="disabled"><span>»</span></li></c:if>
            <c:if test="${p.pageNum!=p.lastPage}"><li><a href="/admin/show?currentIndex=${p.nextPage}">»</a></li></c:if>
          </ul>

        </div>
      </div>
    </div>

  </div>

</div>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="../js/main.min.js"></script>
<script type="text/javascript">
$(function(){
    $('.search-bar .dropdown-menu a').click(function() {
        var field = $(this).data('field') || '';
        $('#search-field').val(field);
        $('#search-btn').html($(this).text() + ' <span class="caret"></span>');
    });
});
</script>
</body>
</html>