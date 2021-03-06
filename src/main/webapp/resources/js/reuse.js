function getCurrentPage(){
    return parseInt($("#pageCurrent").html());
}
function getTotalPage(){
    return parseInt($("#pageTotal").html());
}

function printPageBtn(page){
    var pageList=page["pageList"];
    var a1=$("<a class='page-link' href='#'></a>").text("上一页"),a2=$("<a class='page-link' href='#'></a>").text("下一页");
    var lastPage=$("<li class='page-item lastPage'></li>").append(a1);
    var nextPage=$("<li class='page-item nextPage'></li>").append(a2);
    $(".pagination").html("").append(lastPage);
    for(var i=0;i<pageList.length;i++){
        var a=$("<a class='page-link' href='#' index='"+pageList[i]+"'></a>").text(pageList[i]);
        var li=$("<li class='page-item'></li>").append(a);
        li.on("click",function () {
            printPage($(this).children("a").attr("index"));
        });
        $(".pagination").append(li);
    }
    $(".pagination").append(nextPage);
    $(".lastPage").on("click",function () {
        if(getCurrentPage()-1>0) printPage(getCurrentPage()-1);
    });
    $(".nextPage").on("click",function () {
        if(getCurrentPage()+1<=getTotalPage())printPage(getCurrentPage()+1);
    });
    $("#pageTotal").text(page["pageCount"]);
    $("#pageCurrent").text(page["pageNum"]);
}
function getUserPage(pageNum){
    var page;
    $.ajax({
        url:"/user/page/"+pageNum,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            page=result;
        }
    });
    return page;
}

function getUser(id){
    var user;
    $.ajax({
        url:"/user/"+id,
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

function updateUserState(id,state){
    var param=JSON.stringify({"uid":id,"isforbidden":state});
    $.ajax({
        url:"/user",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"PUT",
        success:function(result){
            if(result['successful']){
                printPage(getCurrentPage());
            }
            else
                alert('修改用户状态失败');
        }
    });
}

function deleteUser(id){
    var param=JSON.stringify({"uid":id});
    $.ajax({
        url:"/user",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"DELETE",
        success:function(result){
            if(result['successful']){
                printPage(getCurrentPage());
            }
            else
                alert("删除用户失败");
        }
    });
}
function getAnnouncePage(pageNum){
    var page;
    $.ajax({
        url:"/announce/page/"+pageNum,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            page=result;
        }
    });
    return page;
}
function getAnnouncement(id){
    var announcement;
    $.ajax({
        url:"/announce/"+id,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            announcement=result;
        }
    });
    return announcement;
}
function addAnnouncement(title,content){
    var param=JSON.stringify({"title":title,"content":content});
    $.ajax({
        url:"/announce",
        dataType:"json",
        contentType:"application/json",
        data:param,
        async:true,
        type:"POST",
        success:function(result){
            if(result['successful']){
                printPage(getCurrentPage());
            }
            else
                alert("添加公告失败");
        }
    });
}
function updateAnnouncement(targetIndex,title,content){
    var param=JSON.stringify({"announcementId":targetIndex,"title":title,"content":content});
    $.ajax({
        url:"/announce",
        dataType:"json",
        contentType:"application/json",
        data:param,
        async:true,
        type:"PUT",
        success:function(result){
            if(result['successful']){
                printPage(getCurrentPage());
            }
            else
                alert("修改公告失败");
        }
    });
}
function deleteAnnouncement(id){
    var param=JSON.stringify({"announcementId":id});
    $.ajax({
        url:"/announce",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"DELETE",
        success:function(result){
            if(result['successful']){
                printPage(getCurrentPage());
            }
            else
                alert("删除公告失败");
        }
    });
}
function getTipOff(id){
    var tipoff;
    $.ajax({
        url:"/tipoff/"+id,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            tipoff=result;
        }
    });
    return tipoff;
}
function getTipoffPage(pageNum){
    var page;
    $.ajax({
        url:"/tipoff/page/"+pageNum,
        type:"GET",
        dataType:"json",
        contentType:"application/json",
        async:false,
        success:function(result){
            page=result;
        }
    });
    return page;
}
function addTipoff(fid,row,col,remark){
    var param=JSON.stringify({"fid":fid,"rownum":row,"colnum":col,"remark":remark});
    $.ajax({
        url:"/tipoff",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"POST",
        success:function (result) {
            if(result['successful'])
                alert("举报成功");
            else
                alert("举报失败");
        }
    });
}
function handleTipoff(id){
    var param=JSON.stringify({"tid":id});
    $.ajax({
        url:"/tipoff",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"PUT",
        success:function (result) {
            if(result['successful'])
                printPage(getCurrentPage());
            else
                alert("处理举报失败");
        }
    });
}
function getViolation(vid){
    var violation;
    $.ajax({
        url:"/violation/"+vid,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            violation=result;
        }
    });
    return violation;
}
function getViolationPage(pageNum){
    var page;
    $.ajax({
        url:"/violation/page/"+pageNum,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            page=result;
        }
    });
    return page;
}
function deleteViolation(vid){
    var param=JSON.stringify({"vid":vid});
    $.ajax({
        url:"/violation",
        dataType:"json",
        contentType:"application/json",
        async:true,
        data:param,
        type:"DELETE",
        success:function(result){
            if(result['successful'])
                printPage(getCurrentPage());
            else
                alert("删除违规记录失败");
        }
    });
}
function getAppointmentPage(pageNum,uname){
    var page;
    $.ajax({
        url:"/main/appointment/page/"+pageNum,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            page=result;
        }
    });
    return page;
}
function getViolationPageByUser(pageNum){
    var page;
    $.ajax({
        url:"/main/violation/page/"+pageNum,
        dataType:"json",
        contentType:"application/json",
        async:false,
        type:"GET",
        success:function(result){
            page=result;
        }
    });
    return page;
}


function addFloor(fname,row,col) {
    var param=JSON.stringify({"fname":fname,"row":row,"col":col});
    $.ajax({
        url:"/floor",
        dataType:"json",
        contentType:"application/json",
        data:param,
        async:true,
        type:"POST",
        success:function(result){
            if(result['successful']){
                printFloorList();
                alert("成功添加楼层");
            }
            else
                alert('添加楼层失败');
        }
    });
}
function deleteFloor(fid){
    $.ajax({
        url:"/floor/"+fid,
        dataType:"json",
        contentType:"application/json",
        async:true,
        type:"DELETE",
        success:function(result){
            if(result['successful']){
                printFloorList();
            }
            else
                alert("删除失败");
        }
    });
}