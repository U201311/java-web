$(document).ready(function(){
    $('#findTable thead').hide();
    findOlderNumber();
    $("button").click(function(){
        confirm();
    });
});
//查找所有老人的编号
function findOlderNumber(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findAll",
        success:function(data){
            var bb =$(document).find("#allname");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ data[i].name+"</option>");
            }

        }
    });
}
