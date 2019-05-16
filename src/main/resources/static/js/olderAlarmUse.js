$(document).ready(function(){
    $('#findTable thead').hide();
    findOlderNumber();
    $("button").click(function(){
        clear();
        confirm();
    });
});
//清空表格
function clear() {
    $('#findTable tbody').empty();
    $('#findTable thead').show();
}
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
function confirm(){
    var oldersId=$("#allname option:selected").val();
    var type=$("#alarmtype option:selected").val();
    if(oldersId!="" && type=="")
    {
        findByOlder();
    }
    if(oldersId=="" && type!=""){
        findBytype();
    }
    if(oldersId!="" && type!=""){
        findByOlderAndType();
    }
}
function findByOlder(){
    var oldersId=$("#allname option:selected").val();
    //alert(oldersId);
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/alarm/findByOlderId/"+oldersId,
        success:function(data){
            //dateFormat="yyyy-MM-dd";
            var s="";
            for(var i=0;i<data.length;i++){
                var time1=(new Date(parseFloat(data[i].alarmTime))).format("yyyy-MM-dd hh:mm:ss");
                var time2 =(new Date(parseFloat(data[i].alarmReplyTime))).format("yyyy-MM-dd hh:mm:ss");
                s = "<tr><td>" + data[i].oldersId+ "</td><td>" + data[i].oldersName + "</td><td>"+data[i].alarmType+ "</td><td>" + data[i].nurseId + "</td><td>"+
                    data[i].nurseName + "</td><td>"+ time1 +"</td><td>"+time2+"</td></tr>";
                $("#findTable").append(s);
            }
        }
    });
}
Date.prototype.format = function(format)  {
    var o = {
        "M+" : this.getMonth() + 1,// month
        "d+" : this.getDate(),// day
        "h+" : this.getHours(),// hour
        "m+" : this.getMinutes(),// minute
        "s+" : this.getSeconds(),// second
        "q+" : Math.floor((this.getMonth() + 3) / 3),// quarter
        "S" : this.getMilliseconds()
        // millisecond
    };
    if (/(y+)/.test(format) || /(Y+)/.test(format)) {
        format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    }
    for ( var k in o) {
        if (new RegExp("(" + k + ")").test(format)) {
            format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
        }
    }
    return format;
};

function findBytype(){
    var type=$("#alarmtype option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/alarm/findByType/"+type,
        success:function(data){
            //dateFormat="yyyy-MM-dd";
            var s="";
            for(var i=0;i<data.length;i++){
                var time1=(new Date(parseFloat(data[i].alarmTime))).format("yyyy-MM-dd hh:mm:ss");
                var time2 =(new Date(parseFloat(data[i].alarmReplyTime))).format("yyyy-MM-dd hh:mm:ss");
                s = "<tr><td>" + data[i].oldersId+ "</td><td>" + data[i].oldersName + "</td><td>"+data[i].alarmType+ "</td><td>" + data[i].nurseId + "</td><td>"+
                    data[i].nurseName + "</td><td>"+ time1 +"</td><td>"+time2+"</td></tr>";
                $("#findTable").append(s);
            }
        }
    });
}

function findByOlderAndType(){
    var olderId=$("#allname option:selected").val();
    var alarmType=$("#alarmtype option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/alarm/findByOlderAndType/"+olderId+"/"+alarmType,
        success:function(data){
            //dateFormat="yyyy-MM-dd";
            var s="";
            for(var i=0;i<data.length;i++){
                var time1=(new Date(parseFloat(data[i].alarmTime))).format("yyyy-MM-dd hh:mm:ss");
                var time2 =(new Date(parseFloat(data[i].alarmReplyTime))).format("yyyy-MM-dd hh:mm:ss");
                s = "<tr><td>" + data[i].oldersId+ "</td><td>" + data[i].oldersName + "</td><td>"+data[i].alarmType+ "</td><td>" + data[i].nurseId + "</td><td>"+
                    data[i].nurseName + "</td><td>"+ time1 +"</td><td>"+time2+"</td></tr>";
                $("#findTable").append(s);
            }
        }
    });

}

