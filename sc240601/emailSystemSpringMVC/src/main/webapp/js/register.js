let check = ()=>{
    let username = document.getElementsByName("username")[0].value;
    let password = document.getElementsByName("password")[0].value;
    let affirm = document.getElementsByName("affirm")[0].value;
    let email = document.getElementsByName("email")[0].value;
    let error = document.getElementById("error");
    if (username==""){
        error.innerText = "用户名为空";
        return false;
    }
    if (password==""){
        error.innerText = "密码为空";
        return false;
    }
    if (affirm==""){
        error.innerText = "确认密码为空";
        return false;
    }
    if (email==""){
        error.innerText = "邮箱为空";
        return false;
    }
    if (password.length<6){
        error.innerText = "密码小于6位";
        return false;
    }
    if (password != affirm){
        error.innerText = "两次密码不一致";
        return false;
    }
    let re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!re.test(email)){
        error.innerText = "邮箱格式错误";
        return false;
    }
    return true;
}