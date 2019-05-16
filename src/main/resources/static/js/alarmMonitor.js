$(document).ready(function(){
    //alert(w1);
   // var h1=$("#imgai").height();
    //var h2=$("#imgai").width();
    //alert(h1);
    //alert(h2);
    //show(w1,h1);
   // draw();
});

function show(a,b,c,d){
    var getdiv=document.getElementById("hdsu");
　　var div=document.createElement("div");
    var h1=$("#imgai").height();
    var h2=$("#imgai").width();
   div.id="div1";
   div.setAttribute("style","position:absolute;z-index:99;background-color:#00ee00;height:100px;width:200px;");
   var d1=(a/8800)*h2;
   alert(d1);
   div.style.left= d1+"px";
   var d2=(b/5600)*h1;
   alert(d2);
   div.style.top=d2+"px";
   div.style.dispaly="block";
   div.innerHTML="老人姓名"+"<br>"+"报警类型"+"<br>"+"报警地点";
   //document.body.appendChild(div);
    getdiv.appendChild(div);
    setTimeout("unshow()",6000);
}

function unshow(){
    document.getElementById('div1').style.display="none";
}

function draw(){
    var ctx=canvas.getContext("2d");
    var pic=new Image();
    pic.src="../images/map.jpg";
    pic.onload=function(){
        ctx.drawImage(pic,0,0);
        ctx.rect(20,20,150,100);
       ctx.stroke();
       //width=8800
        //height=5600
    }
   // b=pic.height;
   // canvas.setAttribute("width",a);
   // canvas.setAttribute("height",b);


        //alert("hello");
    //ctx.fillText("Hello World",10,50);

}
function findAlarm(){
    $.ajax({
        type:"POST",
        dataType:"json",
        contentType: 'charset=utf-8',
        url:"/alarm/startAlarm/",
        success:function(data){
            var bb =$(document).find("#searchnumber");
            bb.append("<option value=\"请选择编号\">请选择编号</option>");
            for ( var i = 0; i < data.length; i++) {
                bb.append("<option value='"+data[i].id+"'>"+ data[i].id+ "</option>");
            }
        },
        error: function (data) {
            console.log(data);
        }
    });
}