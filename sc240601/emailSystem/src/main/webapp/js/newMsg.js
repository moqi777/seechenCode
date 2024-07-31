let check=()=>{
    let toUser = document.getElementsByName("toUser")[0].value;
    let title = document.getElementsByName("title")[0].value;
    let content = document.getElementsByName("content")[0].value;
    var error = document.getElementById("error");
    if (toUser == ""){
        error.innerText = "用户名或邮箱为空";
        return false;
    }
    if (title == ""){
        error.innerText = "标题为空";
        return false
    }
    if (content == ""){
        error.innerText = "内容为空";
        return false
    }
    return true;
}