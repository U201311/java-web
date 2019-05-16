$(document).ready(function(){
    findOlderNumber();
    $("#oldernumber").change(function(){
        confirm();
    });
});
function confirm(){
    var bb=$("#oldernumber option:selected").val();
    if(bb=="未定义")
    {
        clear2();
        $("#search1").empty();
        $("#search2").empty();
        $("#search3").empty();

    }
    else {
        clear2();
        selectOlderById();
        selectBedById();
        selectDeviceById3();
        selectDeviceById1();
        selectDeviceById2();
    }
}
//查找所有老人的编号
function findOlderNumber(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findAll",
        success:function(data){
            var bb =$(document).find("#oldernumber");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ "</option>");
            }

        }
    });
}

//当选中编号改变时，清空下拉栏
function clear(){
    $("#oldername option:selected").each(function () {
        $(this).hide();
    });
    $("#room option").each(function () {
        $(this).hide();
    });
    $("#bedfloor option").each(function () {
        $(this).hide();
    });
    $("#bedroad option").each(function () {
        $(this).hide();
    });
    $("#bednumber option").each(function () {
        $(this).hide();
    });
}

function clear2(){
    $("#oldername").empty();
    $("#room").empty();
    $("#bedfloor").empty();
    $("#bedroad").empty();
    $("#bednumber").empty();
}
//查找所有大小便离床检测终端的编号
function findDeviceByType1(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/device/findByType/大小便离床检测终端",
        success:function(data){
            var bb =$(document).find("#search1");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ "</option>");
            }

        }
    });
}

function selectDeviceById1() {
    var oldersId=$("#oldernumber option:selected").val();
    var deviceName="大小便离床检测终端";
    $("#search1").empty();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findDeviceById/"+oldersId+"/"+deviceName,
        success:function(data){
            var bb =$(document).find("#search1");
            bb.append("<option value='"+data.deviceId+"'>"+ data.deviceId+ "</option>");
        }
    });
}
function selectDeviceById2() {
    var  oldersId=$("#oldernumber option:selected").val();
    var deviceName="洗手间超时检测终端";
    $("#search2").empty();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findDeviceById/"+oldersId+"/"+deviceName,
        success:function(data){
            var dd=$(document).find("#search2");
            dd.append("<option value='"+data.deviceId+"'>"+ data.deviceId+ "</option>");
        }
    });
}
function selectDeviceById3() {
    var  oldersId=$("#oldernumber option:selected").val();
    var deviceName="跌倒检测定位终端";
    $("#search3").empty();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findDeviceById/"+oldersId+"/"+deviceName,
        success:function(data){
            var dd=$(document).find("#search3");
            dd.append("<option value='"+data.deviceId+"'>"+ data.deviceId+ "</option>");
        }
    });
}
//根据选择的老人编号确定老人姓名
function selectBedById(){
    var oldersId=$("#oldernumber option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findBedById/"+oldersId,
        success:function(data){
            var dd=$(document).find("#bedfloor");
            dd.append("<option value='"+data.buildingNumber+"'>"+ data.buildingNumber+ "</option>");
            var ee=$(document).find("#bedroad");
            ee.append("<option value='"+data.buildingRow+"'>"+data.buildingRow+ "</option>");
            var cc =$(document).find("#room");
            cc.append("<option value='"+data.roomNumber+"'>"+ data.roomNumber+ "</option>");
            var ff=$(document).find("#bednumber");
            ff.append("<option value='"+data.number+"'>"+data.number+ "</option>");
        }
    });
}
function selectOlderById(){
    var oldersId=$("#oldernumber option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findById/"+oldersId,
        success:function(data){
            var bb =$(document).find("#oldername");
            bb.append("<option value='"+data.name+"'>"+ data.name+ "</option>");
        }
    });
}
