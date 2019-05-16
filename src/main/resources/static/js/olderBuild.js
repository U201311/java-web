$(document).ready(function(){
    $("#findDevice thead").hide();
    $("button").click(function(){
        confirm();
    });
});

function insertOlder(){
    var obj={
        "id":($("#idnumber ").val()),
        "name" :($("#name ").val()),
        "IdNumber":$("#idcard ").val(),
        "age":$("#age").val(),
        "sex":$("#sex option:selected").val(),
        "healthyState":$("#healthState option:selected").val()

    };
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/addNewRecord",
        data: JSON.stringify(obj),
        success: function(data){}
    });
}