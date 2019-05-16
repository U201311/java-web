$(document).ready(function(){
    $("#findDevice thead").hide();
    findOlderNumber();
    findBedNumber();
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
    if(name=="大小便离床检测终端")
    {
        findlink();
        for(var i=201;i<299;i++)
        {
            var bb =$(document).find("#search2");
            bb.append("<option value='"+i+"'>"+i+ "</option>");
        }
    }
    if(name=="洗手间超时检测终端")
    {
        findlink();
        for(var i=501;i<599;i++)
        {
            var bb =$(document).find("#search2");
            bb.append("<option value='"+i+"'>"+i+ "</option>");
        }
    }
    if(name=="跌倒检测定位终端")
    {
        findlink();
        for(var i=701;i<799;i++)
        {
            var bb =$(document).find("#search2");
            bb.append("<option value='"+i+"'>"+i+ "</option>");
        }
    }
    if(name=="报警提醒终端")
    {
        for(var i=4000;i<4010;i++)
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

function findOlderNumber(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findAll",
        success:function(data){
            var bb =$(document).find("#olderid");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ data[i].name+"</option>");
            }

        }
    });
}
function findBedNumber(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/bed/findAll",
        success:function(data){
            var bb =$(document).find("#bedid");
            for(var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+"</option>");
            }

        }
    });
}


