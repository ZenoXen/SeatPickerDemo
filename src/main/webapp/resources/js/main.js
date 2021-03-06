function getUserNameFromServer(){
    var uname;
    $.ajax({
        url:"/main",
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            uname=result;
        }
    });
    return uname;
}
function mainSeatPageLoadOn() {
    var uname=getUserNameFromServer();
    $("#logoffUname").text(uname['uname']);
    $("#exitLogin").on("click",function(){
        exitLogin();
    });
}
function exitLogin(){
    $.ajax({
        url:"/main/exit",
        dataType:"json",
        contentType:"application/json",
        async:true,
        type:"PUT",
        success:function(result){
            $(location).attr('href', 'login.html');
        }
    });
}
function mainPageLoadOn(){
    printPage(1);
    var uname=getUserNameFromServer();
    $("#logoffUname").text(uname['uname']);
    $("#exitLogin").on("click",function(){
        exitLogin();
    });
}
function printMainPageBtn(page){
    var pageList=page["pageList"];
    $("#pageBtns").html("");
    for(var i=0;i<pageList.length;i++){
        var div=$("<div class='page' id='page"+(i+1)+"' index='"+pageList[i]+"'>");
        div.html(pageList[i]);
        $("#pageBtns").append(div);
        div.on("click",function () {
            printPage($(this).attr("index"));
            $(".page").removeClass("active");
            $(this).addClass("active");
        });
    }
    $("#pageTotal").text(page["pageCount"]);
    $("#pageCurrent").text(page["pageNum"]);
}