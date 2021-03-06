function getSeat(fid,row,col){
    var seat;
    $.ajax({
        url:"/seat?fid="+fid+"&rownum="+row+"&colnum="+col,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            seat=result;
        }
    });
    return seat;
}
function switchSeatImg(row,col,status){
    var seat=$(".seat-list").eq(row-1).children().eq(col-1);
    if(status==0)
        seat.replaceWith('<li class="seat-item"><img src="/resources/images/seat/seat_empty.png"/></li>');
    else if(status==1)
        seat.replaceWith('<li class="seat-item"><img src="/resources/images/seat/seat_sale.png"/></li>');
    else if(status==2)
        seat.replaceWith('<li class="seat-item"><img src="/resources/images/seat/seat_selected.png"/></li>');
    else if(status==3)
        seat.replaceWith('<li class="seat-item"><img src="/resources/images/seat/seat_sold.png"/></li>');
    $(".seat-item").unbind("click");
    addSeatClickEvent();
}
function addSeatUser(fid,row,col){
    var param=JSON.stringify({"fid":fid,"colnum":col,"rownum":row});
    $.ajax({
        url:"/seat/user",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"PUT",
        success:function(result){
            if(result['successful']){
                switchSeatImg(row,col,2);
            }
            else
                alert("修改失败");
        }
    });
}
function getSeatByUser(){
    var seat;
    $.ajax({
        url:"/seat/user",
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            seat=result;
        }
    });
    return seat;
}
function getCurrentUser(){
    var user;
    $.ajax({
        url:"/user",
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            user=result;
        }
    });
    return user;
}
function addSeatClickEvent(){
    $(".seat-item").on("click",function () {
        var row=parseInt($(this).parent().index()/2);
        var col=$(this).index();
        var seat=getSeat(targetIndex,row+1,col+1);
        if(seat['seatStatus']==1){
            var userSeat=getSeatByUser();
            var user=getCurrentUser();
            if(userSeat!=null&&userSeat['sid']!=null){
                alert("请先释放之前选过的座位");
                return;
            }
            else if(user!=null&&user['isforbidden']==1){

                if(user['unlockTime']!=null)
                    alert('由于违规操作，你的账号被冻结了，将于'+user['unlockTime']+"解锁");
                else
                    alert("你的账号已被冻结，请向管理员申诉");
                return;
            }
            $("#input1").val(row+1);
            $("#input2").val(col+1);
            $("#input3").val("可以选座");
            $(".confirm-btn1").removeClass("disabled");
            $("#modal1").modal("show");
        }
        else if(seat['seatStatus']==2){
            $("#input1").val(row+1);
            $("#input2").val(col+1);
            $("#input3").val("已被选,座位将于"+seat['appointment']['releaseTime']+"自动释放");
            $(".confirm-btn1").addClass("disabled");
            $("#modal1").modal("show");
        }
        else if(seat['seatStatus']==3){
            $(".confirm-btn2").removeClass("disabled");
            $("#input4").val(row+1);
            $("#input5").val(col+1);
            var currentUname=getUserNameFromServer()['uname'],seatUser=seat['user']['uname'];
            if(currentUname==seatUser){
                $("#input6").val("你自己的座位");
                $(".confirm-btn2").addClass("disabled");
            }
            else
                $("#input6").val("已被选");
            $("#modal2").modal("show");
        }
    });
}
function initMap(row,col,seats){
    var seatArray = new Array();
    for(var i=0;i<row;i++){//一维数组长度为30
        seatArray[i]=new Array();
        for(var j=0;j<col;j++){//第二维长度为20
            seatArray[i][j]=1;
        }
    }
    for(var i=0;i<seats.length;i++){
        var rownum=seats[i]['rownum'],colnum=seats[i]['colnum'];
        seatArray[rownum-1][colnum-1]=seats[i]['seatStatus'];
    }
    return seatArray;
}
function printAccordingToMap(map){
    var mapBody=$(".mapBody").html("");
    for(var i=0;i<map.length;i++){
        var ul=$("<ul name='chair' class='seat-list'></ul>");
        for(var j=0;j<map[i].length;j++){
            var status=map[i][j];
            var li;
            if(status==0)
                li=$('<li class="seat-item"><img src="/resources/images/seat/seat_empty.png"/></li>');
            else if(status==1)
                li=$('<li class="seat-item"><img src="/resources/images/seat/seat_sale.png"/></li>');
            else if(status==2)
                li=$('<li class="seat-item"><img src="/resources/images/seat/seat_selected.png"/></li>');
            else if(status==3)
                li=$('<li class="seat-item"><img src="/resources/images/seat/seat_sold.png"/></li>');
            ul.append(li);
        }
        mapBody.append(ul).append($("<br>"));
    }
}
function printUserMap(floor){
    $(".mapBody").html("");
    if(floor==null)return;
    targetIndex=floor['fid'];
    var seats=getFloor(targetIndex)['seats'];
    var map=initMap(floor['row'],floor['col'],seats);
    printAccordingToMap(map);
    addSeatClickEvent();
}
function getFloorList(){
    var floors;
    $.ajax({
        url:"/floor",
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            floors=result;
        }
    });
    return floors;
}
function getFloor(fid){
    var floor;
    $.ajax({
        url:"/floor/"+fid,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            floor=result;
        }
    });
    return floor;
}