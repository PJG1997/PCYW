function allocateAuto(){
	if(  window.confirm("确定要自动分配司机跟车辆吗?") == false){
		return;
	}
	//根据其始发配送点，终点配送点查询route表
		//1.获取始发配送点，终点配送点名
	var hids = new Array();		//存储所有被选取的交接单号
	var osids = new Array();		//存储所有被选取的交接单的订单号
	var fromSpnames = new Array();		//存储所有被选取的始发配送点名
	
	if($("input:checked").length <= 0){	//判断用户有没有选中input
		alert("您没有选中任何交接单！");
		return;
	}
		//2.循环被选取的数据input标签，获取被选取的数据
	for(var i=0; i < $("input:checked").length; i++){
		hids[i] = $("input:checked").eq(i).val();
		osids[i] = $("input:checked").eq(i).parent().next().next().text();
		fromSpnames[i] = $("input:checked").eq(i).parent().next().next().next().text();
//		alert(osids[i]);
//		alert(fromSpnames[i]);
	}
		//3.判断交接单里面有没有重复的订单号，有则提示：同一个订单的交接单无法同时分配车辆与司机
	for(var i=0; i < $("input:checked").length; i++){
		for(var j=i+1; j < $("input:checked").length; j++){
			if(osids[i] == osids[j]){
				alert("交接单："+osids[i]+","+osids[j]+"不可同时进行车辆与司机分配，请重新操作！");
				return;
			}
		}
	}
//	var alertStr = "";		//用来存储需要提示的内容
		//4.循环发送请求
	for(var i=0; i < $("input:checked").length; i++){
		//3.循环发送请求到action
		$.ajax({
			async:false, 	//设置ajax的同步
			cache:false,	//设置不缓存order
			url: "handover_allocateAuto?handover.hid="+hids[i]+"&handover.order.osid="+osids[i]+"&handover.hfromSpname="+fromSpnames[i],
			success: function(data){
				if(data=="error"){
					alert("错误，交接单："+hids[i]+"自动分配失败！");
				}else if(data=="input"){
					alert("订单"+osids[i]+"的上行尚未完成，交接单："+hids[i]+"自动分配失败！");
				}else if(data=="nocar"){
					alert("配送点"+fromSpnames[i]+"暂无空闲车辆，交接单："+hids[i]+"自动分配失败！");
				}else if(data=="nodriver"){
					alert("配送点"+fromSpnames[i]+"暂无空闲司机，交接单："+hids[i]+"自动分配失败！");
				}else{
					alert("交接单："+hids[i]+"自动分配成功！");
				}
			}
		});
	}
	alert("自动分配完成！");
	window.location.href="handover_selectAllOldHandovers?handover.hstatus=1";
}
//手动分配车辆
function allocateCar(id){
	var hid = $("#"+id).text();
	var osid = $("#"+id).next().text();
	var spfrom = $("#"+id).next().next().text();
	var surl = 'handover_selectAvailableCarByCon?handover.hfromSpname='+spfrom+'&handover.hid='+hid+'&handover.order.osid='+osid;
	//yemian/jjd/car_query.jsp
	var popup = window.open(surl, '_self', 'width=500,height=400,resizable=1,scrollbars=auto');
	if (popup != null) {
		if (popup.opener == null) {
			popup.opener = self; 
		}
		popup.location.href= surl;
	}
}
//手动分配司机
function allocateDriver(id){
	var hid = $("#"+id).text();
	var osid = $("#"+id).next().text();
	var spfrom = $("#"+id).next().next().text();
	var surl = 'handover_selectAvailableDriverByCon?handover.hfromSpname='+spfrom+'&handover.hid='+hid+'&handover.order.osid='+osid;
	popup = window.open(surl, '_self', 'width=500,height=400,resizable=1,scrollbars=auto');
	if (popup != null) {
		if (popup.opener == null) {
			popup.opener = self; 
		}
		popup.location.href= surl;
	}
}

