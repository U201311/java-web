$(document).ready(function(){
    $("#findDevice thead").hide();
    $("#button1").click(function(){
        clear();
        getDeviceByName();
    });
});
function clear() {
    $('#findDevice tbody').empty();
    $('#findDevice thead').show();
}
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
                    "</td><td><button onclick='deleteDevice("+ data[i].deviceId + ")'>&nbsp删除</td></tr>";
                $("#findDevice").append(s);
            }

        },
        error:function(data){
            console.log(data);
        }
    });
}
function deleteDevice(data){
    alert("确认删除设备编号"+data+"?");
    var deviceId=data;
    $.ajax({
        type:"post",
        dataType:"json",
        url:"/device/deleteDevice/"+deviceId,
        success:function(data){}
    });

}
