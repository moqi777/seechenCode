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
    <p>姓名：<input name="name" onblur="ajax3(this)"><span id="msg"></span></p>
    <p>存款：<input name="money"></p>
    <p>生日：<input type="date" name="time"></p>
    <p>头像：<input name="myhead" type="file" onchange="showImg(this)"></p>
    <p><img id="img" src="https://s2.loli.net/2024/08/02/MgH2iNkdstCPQKB.webp" style="width: 100px;height: 100px;border-radius: 50px"></p>
    <button type="submit">新增</button>
</form>
</body>
<%--先导jQuery--%>
<script src="https://code.jquery.com/jquery-3.0.0.min.js"></script>
<%--先导axios--%>
<script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script>
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
    //原生js实现ajax：实现验证用户可用
    let ajax1 = (input)=>{
        var msg = document.getElementById("msg");
        //1.创建对象
        let ajax = new XMLHttpRequest();
        //2.绑定监听(定义成功和失败回调函数)
        ajax.onreadystatechange=()=>{
            //监听readyState监听连接状态 和status请求状态码
            //连接状态：0未连接 1打开链接 2发送请求 3交互 4完成交互可以接收响应
            if (ajax.readyState==4 && ajax.status==200){
                //表示异步请求已经成功执行完毕 就可以执行成功的回调函数
                //5.接收响应的数据
                let value = ajax.responseText;//后端返回的数据
                msg.innerText = value;
            }
            //除了成功的 其他判断都是失败的 if(){失败的回调函数}
        };
        //3.绑定提交地址
        //参数1：请求方式 get/post
        //参数2：请求地址
        //参数3：是否是异步的请求  true异步  false同步
        ajax.open("get","/usermvc/checkName?name="+input.value,true);
        //4.发送请求
        ajax.send();
    }
    //2.通过jQuery发送异步请求
    let ajax2=input=>{
        $.post("/usermvc/checkName?name="+input.value,"",(res)=>{
            //res就是后端返回的结果，res变量名自定义
            //document.getElementById("msg").innerHTML
            $('#msg').html(res)
        })
    }
    //3.通过axios发送异步请求
    let ajax3=input=>{
        axios.post("/usermvc/checkName?name="+input.value).then(res=>{
            //res.data  后端返回的结果
            $("#msg").html(res.data);
        })
    }
</script>
</html>
