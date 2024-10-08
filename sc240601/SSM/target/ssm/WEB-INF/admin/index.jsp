<%@page contentType="text/html; charset=utf-8" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"/>
    <title>首页 - 光年(Light Year Admin)后台管理系统模板</title>
    <link rel="icon" href="favicon.ico" type="image/ico">
    <meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
    <meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
    <meta name="author" content="yinqi">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/materialdesignicons.min.css" rel="stylesheet">
    <link href="css/style.min.css" rel="stylesheet">
</head>

<body>


<div class="container-fluid">

    <div class="row">
        <div class="col-sm-6 col-lg-3">
            <div class="card bg-primary">
                <div class="card-body clearfix">
                    <div class="pull-right">
                        <p class="h6 text-white m-t-0">今日访问</p>
                        <p class="h3 text-white m-b-0">102,125.00</p>
                    </div>
                    <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                            class="mdi mdi-currency-cny fa-1-5x"></i></span></div>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-lg-3">
            <div class="card bg-danger">
                <div class="card-body clearfix">
                    <div class="pull-right">
                        <p class="h6 text-white m-t-0">访问总数</p>
                        <p class="h3 text-white m-b-0">920,000</p>
                    </div>
                    <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                            class="mdi mdi-account fa-1-5x"></i></span></div>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-lg-3">
            <div class="card bg-success">
                <div class="card-body clearfix">
                    <div class="pull-right">
                        <p class="h6 text-white m-t-0">文章总量</p>
                        <p class="h3 text-white m-b-0">34,005,000</p>
                    </div>
                    <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                            class="mdi mdi-arrow-down-bold fa-1-5x"></i></span></div>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-lg-3">
            <div class="card bg-purple">
                <div class="card-body clearfix">
                    <div class="pull-right">
                        <p class="h6 text-white m-t-0">新增反馈</p>
                        <p class="h3 text-white m-b-0">153 条</p>
                    </div>
                    <div class="pull-left"><span class="img-avatar img-avatar-48 bg-translucent"><i
                            class="mdi mdi-comment-outline fa-1-5x"></i></span></div>
                </div>
            </div>
        </div>
    </div>

    <div class="row">

        <div class="col-lg-12">
            <div class="card">
                <div class="card-header">
                    <h4>最新留言</h4>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead>
                            <tr>
                                <th>#</th>
                                <th>项目名称</th>
                                <th>开始日期</th>
                                <th>截止日期</th>
                                <th>状态</th>
                                <th>进度</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>1</td>
                                <td>设计新主题</td>
                                <td>10/02/2019</td>
                                <td>12/05/2019</td>
                                <td><span class="label label-warning">待定</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-warning" style="width: 45%;"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>2</td>
                                <td>网站重新设计</td>
                                <td>01/03/2019</td>
                                <td>12/04/2019</td>
                                <td><span class="label label-success">进行中</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-success" style="width: 30%;"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>3</td>
                                <td>模型设计</td>
                                <td>10/10/2019</td>
                                <td>12/11/2019</td>
                                <td><span class="label label-warning">待定</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-warning" style="width: 25%;"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>4</td>
                                <td>后台管理系统模板设计</td>
                                <td>25/01/2019</td>
                                <td>09/05/2019</td>
                                <td><span class="label label-success">进行中</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-success" style="width: 55%;"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>5</td>
                                <td>前端设计</td>
                                <td>10/10/2019</td>
                                <td>12/12/2019</td>
                                <td><span class="label label-danger">未开始</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-danger" style="width: 0%;"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>6</td>
                                <td>桌面软件测试</td>
                                <td>10/01/2019</td>
                                <td>29/03/2019</td>
                                <td><span class="label label-success">进行中</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-success" style="width: 75%;"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>7</td>
                                <td>APP改版开发</td>
                                <td>25/02/2019</td>
                                <td>12/05/2019</td>
                                <td><span class="label label-danger">暂停</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-danger" style="width: 15%;"></div>
                                    </div>
                                </td>
                            </tr>
                            <tr>
                                <td>8</td>
                                <td>Logo设计</td>
                                <td>10/02/2019</td>
                                <td>01/03/2019</td>
                                <td><span class="label label-warning">完成</span></td>
                                <td>
                                    <div class="progress progress-striped progress-sm">
                                        <div class="progress-bar progress-bar-success" style="width: 100%;"></div>
                                    </div>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

    </div>

</div>


<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/perfect-scrollbar.min.js"></script>
<script type="text/javascript" src="js/main.min.js"></script>


</body>
</html>