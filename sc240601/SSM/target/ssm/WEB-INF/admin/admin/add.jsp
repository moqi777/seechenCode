<%@page contentType="text/html; charset=utf-8" isELIgnored="false" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" />
<title>新增文档 - 光年(Light Year Admin)后台管理系统模板</title>
<link rel="icon" href="../favicon.ico" type="image/ico">
<meta name="keywords" content="LightYear,光年,后台模板,后台管理系统,光年HTML模板">
<meta name="description" content="LightYear是一个基于Bootstrap v3.3.7的后台管理系统的HTML模板。">
<meta name="author" content="yinqi">
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/materialdesignicons.min.css" rel="stylesheet">
<!--标签插件-->
<link rel="stylesheet" href="../js/jquery-tags-input/jquery.tagsinput.min.css">
<link href="../css/style.min.css" rel="stylesheet">
</head>
  
<body>
<div class="container-fluid">

  <div class="row">
    <div class="col-lg-12">
      <div class="card">
        <div class="card-body">

          <form action="/admin/add" method="post" class="row" enctype="multipart/form-data">
            <div class="form-group col-md-12">
              <label for="name">用户名</label>
              <div class="form-controls">
                <input type="text" class="form-control" id="name" name="account" value="" placeholder="请输入用户名" onblur="checkAdminName(this)"/>
              </div>
            </div>
            <p id="checkNameError" style="color: red"></p>
            <div class="form-group col-md-12">
              <label for="title">姓名</label>
              <input type="text" class="form-control" id="title" name="name" value="" placeholder="姓名" />
            </div>
            <div class="form-group col-md-12">
              <label for="seo_keywords">密码</label>
              <input type="password" class="form-control" id="password" name="password" value="" placeholder="密码" />
            </div>
            <div class="form-group col-md-12">
              <label for="seo_keywords">确认密码</label>
              <input type="password" class="form-control" id="seo_keywords" name="re_password" value="" placeholder="确认密码" />
            </div>
            <div class="form-group col-md-12">
              <label for="phone">手机</label>
              <input class="form-control" id="phone" name="phone" value="" placeholder="手机号"></input>
            </div>
            <div class="form-group col-md-12">
              <label for="email">邮箱</label>
              <input class="form-control" id="email" name="email"  value="" placeholder="邮箱"></input>
            </div>
            <div class="form-group col-md-12">
              <label>头像</label>
              <div class="form-controls">

                <ul class="list-inline clearfix lyear-uploads-pic">
                  <img style="position:absolute;width: 600px;height: 600px;top: -300px;left:300px;display: none" id="bigImg"></img>
                  <li class="col-xs-4 col-sm-3 col-md-2" style="display: none" id="imgShow">
                    <figure>
                      <img src="" alt="图片一" id="img">
                      <figcaption>
                        <a class="btn btn-round btn-square btn-primary" href="#!" onclick="imgShow()"><i class="mdi mdi-eye"></i></a>
                        <a class="btn btn-round btn-square btn-danger" href="#!" onclick="delImg()"><i class="mdi mdi-delete"></i></a>
                      </figcaption>
                    </figure>
                  </li>
                  <li class="col-xs-4 col-sm-3 col-md-2" id="fileUpload">
                    <a class="pic-add" id="add-pic-btn" href="#!" title="点击上传" onclick="openFile()"></a>
                  </li>
                  <input type="file" style="display: none" id="file" onchange="uploadFile(this)" name="imgFile">
                </ul>
              </div>
            </div>
            <div class="form-group col-md-12">
              <label for="sex">性别</label>
              <div class="clearfix">
                <label class="lyear-radio radio-inline radio-primary">
                  <input type="radio" name="sex" value="1"><span>男</span>
                </label>
                <label class="lyear-radio radio-inline radio-primary">
                  <input type="radio" name="sex" value="0" checked><span>女</span>
                </label>
              </div>
            </div>

            <div class="form-group col-md-12">
              <label for="status">状态</label>
              <div class="clearfix">
                <label class="lyear-radio radio-inline radio-primary">
                  <input type="radio" name="status" value="2"><span>禁用</span>
                </label>
                <label class="lyear-radio radio-inline radio-primary">
                  <input type="radio" name="status" value="1" checked><span>启用</span>
                </label>
                <label class="lyear-radio radio-inline radio-primary">
                  <input type="radio" name="status" value="0" checked><span>暂定</span>
                </label>
              </div>
            </div>
            <div class="form-group col-md-12">
              <button type="submit" class="btn btn-primary ajax-post" target-form="add-form" onclick="return submit1()">确 定</button>
              <button type="button" class="btn btn-default" onclick="location.href='/admin/show'">返 回</button>
            </div>
            <p style="color: red" id="submitError"></p>
          </form>

        </div>
      </div>
    </div>

  </div>

</div>

<script type="text/javascript" src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/perfect-scrollbar.min.js"></script>
<!--1.导入axios环境 网络导入 本地导入 vue导入，注意要先导包-->
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
<!--标签插件-->
<script src="../js/jquery-tags-input/jquery.tagsinput.min.js"></script>
<script type="text/javascript" src="../js/main.min.js"></script>
<script>
  let checkAdminName = (adminName)=>{
    let data = {
      account:adminName.value
    }
    axios.post("/admin/checkName",data).then(res=>{
      if (res.data.code==0){
        document.getElementById("checkNameError").innerText = "用户名已存在";
      }else {
        document.getElementById("checkNameError").innerText = "";
      }
    })
  }
  let openFile = ()=>{
    let file = document.getElementById('file');
    file.click();
  }
  let uploadFile = (file)=>{
    let imgFile = file.files[0];
    let url = window.URL.createObjectURL(imgFile);
    document.getElementById("img").setAttribute("src",url);
    document.getElementById("bigImg").setAttribute("src",url)
    document.getElementById("fileUpload").style.display="none";
    document.getElementById("imgShow").style.display="block";
  }
  let delImg = ()=>{
    document.getElementById("file").value="";
    document.getElementById("fileUpload").style.display="block";
    document.getElementById("imgShow").style.display="none";
  }
  let imgShow = ()=>{
    document.getElementById("bigImg").style.display = "block";
    // 事件绑定放在图片显示后
    document.onmouseup = () => {
      document.getElementById("bigImg").style.display = "none";
      document.onmouseup = null; // 解绑事件处理程序
    };
  }
  let submit1 = ()=>{
    if (document.getElementById("checkNameError").innerText!=""){
      return false;
    }
    let name = document.getElementById("name");//用户名
    let title = document.getElementById("title");//姓名
    let password = document.getElementById("password");//密码
    let seo_keywords = document.getElementById("seo_keywords");//确认密码
    let phone = document.getElementById("phone");//电话
    let email = document.getElementById("email");//邮箱
    let file = document.getElementById("file");//头像
    let submitError = document.getElementById("submitError");
    if (name.value==""||name.value==null){
      submitError.innerText = "用户名为空";
      return false;
    }
    if (title.value==""||title.value==null){
      submitError.innerText = "姓名为空";
      return false;
    }
    if (password.value==""||password.value==null){
      submitError.innerText = "密码为空";
      return false;
    }
    if (password.value.length < 6){
      submitError.innerText = "密码小于六位";
      return false;
    }
    if (password.value != seo_keywords.value){
      submitError.innerText = "两次密码不一致";
      return false;
    }
    if (phone.value==""||phone.value==null){
      submitError.innerText = "手机号码为空";
      return false;
    }
    // 手机号正则表达式，匹配中国大陆 11 位手机号
    const phonePattern = /^1[3-9]\d{9}$/;
    if (!phonePattern.test(phone.value)){
      submitError.innerText = "手机号码错误";
      return false;
    }
    // 邮箱正则表达式，匹配常见的邮箱格式
    const emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(email.value)){
      submitError.innerText = "邮箱格式错误";
      return false;
    }
    if (email.value==""||email.value==null){
      submitError.innerText = "邮箱为空";
      return false;
    }
    if (file.files.length==0){
      submitError.innerText = "请上传头像";
      return false;
    }
    return true;
  }
</script>
</body>
</html>