$(document).ready(function(){
    $('#findTable').hide();
    findOlderNumber();
    $('#button2').click(function(){
        clear();
        getOlderDetailById();
        getFamilyById();
        getBedById();
    });
});
function clear() {
   // $('#findTable tbody').empty();
    $('#findTable').show();
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

function  getOlderDetailById(){
    var olderId=$("#allname option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findById/"+olderId,
        success:function(data){
            $("#numberid").text(data.id);
            $("#name").text(data.name);
            $("#sex").text(data.sex);
            $("#age").text(data.age);
            $("#state").text(data.remark);
            $("#healthy").text(data.healthyState);
            $("#card").text(data.idNumber);
            $("#nation").text(data.nation);
            //dateFormat="yyyy-MM-dd";
        }
    });
}

function getFamilyById(){
    var olderId=$("#allname option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/family/findFamily/"+olderId,
        success:function(data){
            var s="";
            for(var i=0;i<data.length;i++){
                s="<tr><td>家属姓名</td><td>"+data[i].name+"</td><td>家属联系方式</td><td>"+data[i].phoneNumber+"</td></tr>"+
                    "<tr><td>家属微信</td><td>"+data[i].weChat+"</td></tr>";
                $("#findTable").append(s);
                //dateFormat="yyyy-MM-dd";
            }
        }
    });
}
function getBedById(){
    var olderId=$("#allname option:selected").val();
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'application/json;charset=utf-8',
        url:"/older/findBedById/"+olderId,
        success:function(data){
            var s="";
            s="<tr><td>楼号</td><td>"+data.buildingNumber+"</td><td>房间号</td><td>"+data.roomNumber+
                "</td></tr><tr><td>床位号</td><td>"+data.number+"</td><td>排号</td><td>"+data.buildingRow+"</td></tr>";
            $("#findTable").append(s);
            //dateFormat="yyyy-MM-dd";
        }
    });
}

