$(document).ready(function(){
    $("button").click(function() {
        login();
    });
});

function login(){
    var username=$("#username").val();
    var password=$("#userpass").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/main/login/"+username+"/"+password,
        data:{},
        success:function(data){
            if(data==true)
            {window.location.href="index.html";}
            else {
                alert("输入有误，请重新输入！");
            }
        }
    });
}
/*
$("#btn_login").click(function(){
    var loginObj = new Object();
    loginObj.accountNo= $("#inputAccount").val();
    loginObj.pwd= $("#inputPassword").val();
    var loginJson = JSON.stringify(loginObj); //将JSON对象转化为JSON字符
    $.post('main/login',
        {"loginObj":loginJson},
        function(){

        });
});*/