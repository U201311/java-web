$(document).ready(function(){
   // $('#findTable thead').hide();
    $(function(){
        getId();
        getOlderDetailById();
        getFamilyById();
        getBedById();
    });

});
function clear() {
    $('#findTable tbody').empty();
    $('#findTable thead').show();
}
function getId(){
    var xx = $.getUrlParam('number');
    $("#name1").text(xx);
};
(function ($) {
    $.getUrlParam = function (name) {
        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if (r != null) return unescape(r[2]); return null;
    }
})(jQuery);

function  getOlderDetailById(){
    var olderId=$.getUrlParam('number');
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
    var olderId=$.getUrlParam('number');
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
    var olderId=$.getUrlParam('number');
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

