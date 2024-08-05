<%--
  Created by IntelliJ IDEA.
  User: 86134
  Date: 2024/8/1
  Time: 16:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增</title>
</head>
<body>
<%--不写默认值：enctype="application/x-www-form-urlencoded" 表单按字符串提交--%>
<form action="/usermvc/add" method="post" enctype="multipart/form-data">
    <p>姓名：<input name="name"></p>
    <p>存款：<input name="money"></p>
    <p>生日：<input type="date" name="time"></p>
    <p>头像：<input name="myhead" type="file" onchange="showImg(this)"></p>
    <p><img id="img" src="https://s2.loli.net/2024/08/02/MgH2iNkdstCPQKB.webp" style="width: 100px;height: 100px;border-radius: 50px"></p>
    <button type="submit">新增</button>
</form>
</body>
<script>
    //上传头像立即改变
    let showImg = (o)=>{
        //1.获取type=file组件对象中文件获取出来
        let imgFile = o.files[0];
        //2.通过文件对象 获取地址 (不是真实地址 而是虚拟地址)
        let src = window.URL.createObjectURL(imgFile);
        //3.img标签src属性 设置这个地址
        document.getElementById("img").setAttribute("src",src);
    }
</script>
</html>
