let check=()=>{
    let username = document.getElementsByName("username")[0].value;
    let password = document.getElementsByName("password")[0].value;
    var error = document.getElementById("error");
    if (username == ""){
        error.innerText = "用户名为空";
        return false;
    }
    if (password == ""){
        error.innerText = "密码为空";
        return false
    }
    if (password.length <6){
        error.innerText = "密码小于6位";
        return false
    }
    return true;
}
