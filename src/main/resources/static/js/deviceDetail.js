$(document).ready(function(){
    $('#findTable thead').hide();
    $(function(){
        getId();
        clear();
        getDeviceById();
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
function getDeviceById(){
    var deviceId=$.getUrlParam('number');
    alert(deviceId);
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/device/findDeviceById/"+deviceId,
        data:{
        },
        success: function (data) {
                s = "<tr><td>" + data.deviceId+ "</td><td>" + data.deviceName + "</td><td>" + data.netState +
                    "</td><td>"+ data.serviceState +"</td><td>"+ data.linkedDevice + "</td></tr>";
                $("#findTable").append(s);

        }
    });
}