let isExit = ()=>{
    var b = confirm("确认退出？");
    if (b){
        location.href="/emailUser/exit";
    }
}