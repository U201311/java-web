$(document).ready(function(){
    $("#findDevice thead").hide();
    $("#type").change(function(){
        clear();
        confirm();
    });
    $("#button1").click(function(){
        addNew();
    });
});
function findlink(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/device/findByType/设备提醒终端",
        success: function(data){
            for(var i=1;i<data.length;i++)
            {
                var bb =$(document).find("#linkeddevice");
                bb.append("<option value='"+data[i].deviceId+"'>"+data[i].deviceId+ "</option>");
            }
        }
    });
}
function clear(){
    $("#search2 option").each(function () {
        $(this).hide();
    });
}

function confirm(){
    var name=$("#type option:selected").val();
    if(name=="助行机器人")
    {
        for(var i=1;i<10;i++)
        {
            var bb =$(document).find("#search2");
            bb.append("<option value='"+i+"'>"+i+ "</option>");
        }
    }
    if(name=="助浴机器人")
    {
        for(var i=101;i<110;i++)
        {
            var bb =$(document).find("#search2");
            bb.append("<option value='"+i+"'>"+i+ "</option>");
        }
    }
    if(name=="情感陪护机器人")
    {
        for(var i=301;i<330;i++)
        {
            var bb =$(document).find("#search2");
            bb.append("<option value='"+i+"'>"+i+ "</option>");
        }
    }
}

function addNew(){
    var name=$("#type option:selected").val();
    var number=$("#search2 option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/device/addNewRecord",
        data: JSON.stringify(obj),
        success: function(data){}
    });
}


