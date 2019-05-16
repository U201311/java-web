$(document).ready(function(){
    findOlderNumber();
    $('#findTable thead').hide();
    $('button').click(function(){
        confirm();
    });
});
function confirm(){
    var oldersId= $("#allname option:selected").val();
    var type= $("#sex option:selected").val();
    var state=$("#state option:selected").val();
    if(oldersId!=""&& type==""&& state=="")
    {
        $(function(){
            alert("查询老人");
            clear();
            findByOlder();
        });
    }
    if(oldersId==""&&type==""&&state=="")
    {
        $(function(){
            clear();
            findAll();
        });
    }
    if(oldersId==""&&type==""&&state!="")
    {
        $(function(){
            clear();
            findByState();
       });
    }
    if(oldersId==""&&type!=""&&state=="")
    {
        $(function(){
            clear();
            findBySex();
        });
    }

}

function clear() {
    $('#findTable tbody').empty();
    $('#findTable thead').show();
}
//查找所有老人
function findAll(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType:'application/json;charset=utf-8',
        url:"/older/findAll",
        success:function(data){
            var s="";
            for(var i=0;i<data.length;i++){
                s = "<tr><td>" + data[i].id+ "</td><td>" + data[i].name + "</td><td>" +
                    data[i].sex + "</td><td>"+ data[i].age +"</td><td>正常</td><td>"+ data[i].healthyState +
                    "</td><td><a href='olderDetail.html?number=" +data[i].id+ "'>查看 &nbsp</button><a href='olderModify.html?number=" +data[i].id + "' >&nbsp修改</td></tr>";
                $("#findTable").append(s);
            }
        }
    });
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
function findByOlder(){
    var olderId=$("#allname option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findById/"+olderId,
        success:function(data){
            //dateFormat="yyyy-MM-dd";
            var s="";
                s = "<tr><td>" + data.id+ "</td><td>" + data.name + "</td><td>" +
                    data.sex + "</td><td>"+ data.age +"</td><td>正常</td><td>"+ data.healthyState +
                    "</td><td><a href='olderDetail.html?number=" +data.id+ "'>查看 &nbsp</button><a href='olderModify.html?number=" +data.id + "' >&nbsp修改</td></tr>";
                $("#findTable").append(s);

        }
    });
}
//根据老人性别查找老人
function findBySex(){
    var sex=$("#sex option:selected").val();
    //alert(oldersId);
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findBySex/"+sex,
        success:function(data){
            //dateFormat="yyyy-MM-dd";
            var s="";
            for(var i=0;i<data.length;i++){
                s = "<tr><td>" + data[i].id+ "</td><td>" + data[i].name + "</td><td>" +
                    data[i].sex + "</td><td>"+ data[i].age +"</td><td>正常</td><td>"+ data[i].healthyState +
                    "</td><td><a href='olderDetail.html?number=" +data[i].id+ "'>查看 &nbsp</button><a href='olderModify.html?number=" +data[i].id + "' >&nbsp修改</td></tr>";
                $("#findTable").append(s);
            }
        }
    });
}

//根据护理等级查询
function findByState(){
    var healthyState=$("#state option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findByHealthyState/"+healthyState,
        success:function(data){
            var s="";
            for(var i=0;i<data.length;i++){
                s = "<tr><td>" + data[i].id+ "</td><td>" + data[i].name + "</td><td>" +
                    data[i].sex + "</td><td>"+ data[i].age +"</td><td>正常</td><td>"+ data[i].healthyState +
                    "</td><td><a href='olderDetail.html?number=" +data[i].id+ "'>查看 &nbsp</button><a href='olderModify.html?number=" +data[i].id + "' >&nbsp修改</td></tr>";
                $("#findTable").append(s);
            }
        }
    });
}