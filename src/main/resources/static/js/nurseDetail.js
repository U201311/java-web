$(document).ready(function(){
    $('#findTable thead').hide();
    $(function(){
        getId();
        clear();
        findById();
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

function findById(){
    var nurseId=$.getUrlParam('number');
    $.ajax({
        type: "POST",
        dataType: "json",
        url: "/nurse/findNurseById/"+nurseId,
        data:{
        },
        success: function (data) {
            s = "<tr><td>" + data.id+ "</td><td>" + data.name + "</td><td>" + data.sex +
                "</td><td>"+ data.phoneNumber + "</td></tr>";
            $("#findTable").append(s);

        }
    });
}