$(document).ready(function(){
    $('#findTable thead').hide();
    $('button').click(function(){
        clear();
        findAll();
    });
});
function clear() {
    $('#findTable tbody').empty();
    $('#findTable thead').show();
}
function findAll(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType:'application/json;charset=utf-8',
        url:"/nurse/findAll",
        success:function(data){
            var s="";
            for(var i=0;i<data.length;i++){
                s = "<tr><td>" + data[i].id+ "</td><td>" + data[i].name + "</td><td>" +
                    data[i].sex + "</td><td>"+ data[i].phoneNumber +
                    "</td><td><a href='nurseDetail.html?number=" +data[i].id+ "'>查看 &nbsp</button><a href='nurseModify.html?number=" +data[i].id + "' >&nbsp修改</td></tr>";
                $("#findTable").append(s);
            }
        }
    });
}