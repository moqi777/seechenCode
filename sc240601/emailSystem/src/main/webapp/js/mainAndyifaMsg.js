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
//删除勾选事件
let deleteCheckbox = ()=>{
    var b = confirm("确认删除勾选的邮件？");
    if (b){
        //获取到所有的按钮
        var checkbox = document.querySelectorAll(".checkbox");
        //如果全选按钮的checked属性是true,证明该按钮被选中了
        if (checkboxAll.checked==true){

        }
    }
}