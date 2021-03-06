function getSeat(fid,row,col){
    var seat;
    $.ajax({
        url:"/seat?fid="+fid+"&rownum="+row+"&colnum="+col,
        dataType:"json",
        type:"GET",
        contentType:"application/json",
        async:false,
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
        seat.replaceWith('<li class="seat-item"><img src="/resources/images/seat/seat_sold.png"/></li>');
    $(".seat-item").unbind("click");
    addSeatClickEvent();
}
function switchSeatStatus(fid,row,col,status){
    var param=JSON.stringify({"fid":fid,"colnum":col,"rownum":row,"seatStatus":status});
    $.ajax({
        url:"/seat/status",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"PUT",
        success:function(result){
            if(result['successful']){
                switchSeatImg(row,col,status);
            }
            else
                alert("修改失败");
        }
    });
}
function addSeatClickEvent(){
    $(".seat-item").on("click",function () {
        var row=parseInt($(this).parent().index()/2);
        var col=$(this).index();
        var seat=getSeat(targetIndex,row+1,col+1);
        if(seat['seatStatus']==0)
            switchSeatStatus(targetIndex,row+1,col+1,1);
        else if(seat['seatStatus']==1)
            switchSeatStatus(targetIndex,row+1,col+1,0);
        else{
            alert("该座位正在被使用,无法更改");
            return;
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
function printAdminMap(floor){
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