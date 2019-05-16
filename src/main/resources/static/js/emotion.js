$(document).ready(function(){
    findOlderNumber();
    findNurseNumber();
    findDeviceNumber();
    $("#number").change(function(){
        clear();
        selectOlderById();
    });
    $("#nursenumber").change(function(){
        clear();
        selectNurseById();
    });
    $("#MessageButtsendon").click(function(){
        clear();
        addNewRecord();
    });
});
function confirm(){
}

function clear() {
    $('#findTable tbody').empty();
    $('#findTable thead').show();
}
//根据老人id获取老人姓名
function selectOlderById(){
    var id=$("#number option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findById/"+id,
        success:function(data){
            var bb =$(document).find("#oldername");
            bb.append("<option value='"+data.name+"'>"+ data.name+ "</option>");
        }
    });
}
//根据护工id查找护工姓名
function selectNurseById(){
    var id=$("#nursenumber option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/nurse/findById/"+id,
        success:function(data){
            var bb =$(document).find("#nursename");
            bb.append("<option value='"+data.name+"'>"+ data.name+ "</option>");
        }
    });
}
//查找所有老人编号
function findOlderNumber(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findAll",
        success:function(data){
            var bb =$(document).find("#number");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ "</option>");
            }

        }
    });
}
//查找所有护工编号
function findNurseNumber(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/nurse/findAll",
        success:function(data){
            var bb =$(document).find("#nursenumber");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ "</option>");
            }

        }
    });
}
//查找设备编号
function findDeviceNumber(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/robot/findByType/情感陪护机器人",
        success:function(data){
            var bb =$(document).find("#bathnumber");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ "</option>");
            }
        }
    });
}

function addNewRecord() {
    var obj={
        "deviceId":($("#bathnumber option:selected").val()),
        "oldersId":($("#number option:selected").val()),
        "nurseId" :($("#nursenumber option:selected").val()),
        "olderName":$("#oldername option:selected").val(),
        "nurseName":$("#nursename option:selected").val(),
        "deviceType":"康复机器人"
    };
    obj['BeginTime']=$("#date").val();
    var time=$("#date").val();
    alert(time);
    obj['EndTime']=$("#dateend").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/deviceUse/addNewRecord",
        data: JSON.stringify(obj),
        success: function(data){}
    });
}