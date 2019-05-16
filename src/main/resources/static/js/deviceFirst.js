$(document).ready(function(){
    $("#findDevice thead").hide();
    $("button").click(function(){
        confirm();
    });
});
function confirm(){
    var name=$("#search1 option:selected").val();
    if(name!="未定义" ){
        clear();
        robotOrDEVICE();
    }
    if(name=="未定义" ){
        alert("未选择设备");
        clear();
    }
}

function robotOrDEVICE(){
    var type=$("#search1 option:selected").val();
    if(type=="助行机器人"||type=="助浴机器人"||type=="情感陪护机器人"||type=="生理参数采集设备")
    {
        findAllRobot();
    }else{
        getDeviceByName();
    }

}
function clear() {
    $('#findDevice tbody').empty();
    $('#findDevice thead').show();
}
function deviceclear()
{
    $("#searchnumber").find("option:selected").text("");
    $("#searchnumber option").each(function () {
        $(this).hide();
    });

};
function getDeviceByName(){
    var type=$("#search1 option:selected").val();
    var s="";
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/device/findByType/"+type,
        success:function(data){
            for(var i=0;i<data.length;i++){
                s = "<tr><td>" + data[i].deviceId+ "</td><td>" + data[i].deviceName + "</td><td>" + data[i].netState +
                   "</td><td>"+ data[i].serviceState +"</td><td>"+ data[i].linkedDevice +
                    "</td><td><a href='deviceDetail.html?number=" +data[i].deviceId+ "'>查看 &nbsp</button><a href='deviceModify.html?number=" +data[i].deviceId + "' >&nbsp修改</td></tr>";
                $("#findDevice").append(s);
            }

        },
        error:function(data){
            console.log(data);
        }
    })
}

function findAllRobot(){
    var type=$("#search1 option:selected").val();
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/robot/findByType/"+type,
        success:function(data){
            for(var i=0;i<data.length;i++){
                s = "<tr><td>" + data[i].id+ "</td><td>" + data[i].robotName + "</td><td>" + data[i].netState +
                    "</td><td>"+ data[i].serviceState +"</td><td>"+ data[i].linkedDevice +
                    "</td><td><a href='robotDetail.html?number=" +data[i].id+ "'>查看 &nbsp</button><a href='robotModify.html?number=" +data[i].id + "' >&nbsp修改</td></tr>";
                $("#findDevice").append(s);
            }

        },
        error:function(data){
            console.log(data);
        }
    })
}
