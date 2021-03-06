function releaseSeat(fid,rownum,colnum){
	var param=JSON.stringify({"fid":fid,"rownum":rownum,"colnum":colnum});
	$.ajax({
		url:"/seat/release",
		dataType:"json",
		contentType:"application/json",
		data:param,
		async:true,
		type:"PUT",
		success:function(result){
			if(result['successful'])
				printSeatInfo();
			else
				alert("操作失败");
		}
	});
}
function cancelSeat(fid,rownum,colnum){
	var param=JSON.stringify({"fid":fid,"rownum":rownum,"colnum":colnum});
	$.ajax({
		url:"/seat/cancel",
		dataType:"json",
		contentType:"application/json",
		data:param,
		async:true,
		type:"PUT",
		success:function(result){
			if(result['successful'])
				printSeatInfo();
			else
				alert("取消失败");
		}
	});
}
function registerSeat(fid,rownum,colnum){
	var param=JSON.stringify({"fid":fid,"rownum":rownum,"colnum":colnum});
	$.ajax({
		url:"/seat/register",
		dataType:"json",
		contentType:"application/json",
		data:param,
		async:true,
		type:"PUT",
		success:function(result){
			if(result['successful'])
				printSeatInfo();
			else
				alert("签到失败");
		}
	});
}