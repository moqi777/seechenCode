//单击标题读邮件事件
let readEmail = (b)=>{
    let email_id = b.previousElementSibling.value;
    //获取到邮件Id就可以展示邮件了
    //跳转到控制层进行查询该邮件
    //并对邮件的已读性进行判断
    location.href="/email?type=readEmail&email_id="+email_id;
}
//点击全选按钮事件
let allCheckbox = (checkboxAll)=>{
    //获取到所有的按钮
    var checkbox = document.querySelectorAll(".checkbox");
    //如果全选按钮的checked属性是true,证明该按钮被选中了
    if (checkboxAll.checked==true){
        //选中了就遍历所有的其他按钮，将其设置为true，即选中
        checkbox.forEach(value=>{
            value.checked=true;
        })
    }else {
        checkbox.forEach(value=>{
            value.checked=false;
        })
    }

}
//main.jsp独有单击事件，条件查询
let searchinp = ()=>{
    let value = document.querySelectorAll(".searchinp")[0].value;
    location.href="/email?type=selectEmail&fromOrTo=0&index=1&value="+value;
}
//删除勾选事件
let deleteCheckbox = (currentIndex,mainOrYifaMsg)=>{
    var b = confirm("确认删除勾选的邮件？");
    if (b){
        //获取到所有的按钮
        var checkbox = document.querySelectorAll(".checkbox");
        //获取到按了按钮的总条数
        let i = 0;
        checkbox.forEach(value => {
            if (value.checked==true){
                i++;
            }
        })
        //只有总条数大于0才发起请求，防止发送无效请求
        if (i>0){
            //判断一下如果删了这么多条是否需要往前条一页
            if (checkbox.length==i){//表示这一页都删完，所以要往前跳一页
                currentIndex = currentIndex - 1;
            }
            let myForm = document.getElementById("myform");
            myForm.action = "/email?type=deleteCheckbox&currentIndex="+currentIndex+"&mainOrYifaMsg="+mainOrYifaMsg;
            myForm.submit();
        }
    }
}
//已读候选邮件
let yesRead = (currentIndex)=>{
    //获取到所有的按钮
    var checkbox = document.querySelectorAll(".checkbox");
    //遍历按钮，只有发现有一个为true才发送请求。防止发送无效请求
    checkbox.forEach(value => {
        if (value.checked==true){
            let myForm = document.getElementById("myform");
            myForm.action = "/email?type=yesRead&currentIndex="+currentIndex;
            myForm.submit();
        }
    })
}