
$(document).ready(function(){
    findOlderNumber();
    $('#findTable thead').hide();
    $('button').click(function(){
        var olderId=$("#allname option:selected").val();
        alert("确认删除老人"+olderId);
        deleteOlder();
    });
});
function clear() {
    $('#findTable tbody').empty();
    $('#findTable thead').show();
}

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
//根据老人ID查找老人
function deleteOlder(){
    var olderId=$("#allname option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/deleteOlder/"+olderId,
        success:function(data){
        }
    });
}